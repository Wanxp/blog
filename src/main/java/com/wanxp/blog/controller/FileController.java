package com.wanxp.blog.controller;

import com.wanxp.blog.model.entity.File;
import com.wanxp.blog.service.FileService;
import com.wanxp.blog.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

/**
 * 文件系统
 * 改编自@url{https://github.com/waylau/mongodb-file-server.git}
 */
@Controller
@RequestMapping("/file")
@Api(tags = "file")
public class FileController {

    @Value("${file.server.host}")
    private String fileServerHost;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private FileService fileService;

    /**
     * 文件管理页面
     * @return
     */
    @GetMapping("/manager")
    @ApiOperation("manager")
    public String manager(Model model) {
        List<File> files = fileService.listFilesByPage(0, 10);
        model.addAttribute("message", "welcome to file manager!");
        model.addAttribute("files", files);
        return "/file/manager";
    }
    /**
     * 文件管理页面
     * @return
     */
    @GetMapping("/")
    @ApiOperation("home")
    public String home(Model model) {
        List<File> files = fileService.listFilesByPage(0, 10);
        model.addAttribute("message", "welcome to file manager!");
        model.addAttribute("files", files);
        return "redirect:/file/manager";
    }


    /**
     * 获取文件片信息
     *
     * @param id
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation("fileInfo")
    public ResponseEntity<Object> serveFile(@PathVariable String id) throws UnsupportedEncodingException {

        Optional<File> file = fileService.getFileById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }
    }
    /**
     * 获取文件片信息
     *
     * @param
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/image/user/head/{fileName}/{size}")
    @ResponseBody
    @ApiOperation("image")
    public ResponseEntity<Object> image(@PathVariable(name = "fileName") String fileName,
                                        @PathVariable(name = "size") String size) throws UnsupportedEncodingException {

        Optional<File> file = fileService.getFileByPathAndName("/user/head/" + size + "/", fileName + ".png");

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
                    .header(HttpHeaders.CONTENT_TYPE, "image/png")
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("image was not fount");
        }
    }

    /**
     * 分页查询文件
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("/files/{pageIndex}/{pageSize}")
    @ResponseBody
    @ApiOperation("files")
    public List<File> listFilesByPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        return fileService.listFilesByPage(pageIndex, pageSize);
    }


    /**
     * 在线显示文件
     *
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    @ResponseBody
    @ApiOperation("display")
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

        Optional<File> file = fileService.getFileById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }

    }

    /**
     * 上传
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    @ApiOperation("upload-page")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            File f = transformFile(file);
            fileService.saveFile(f);
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
            return "redirect:/file/manager";
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/file/manager";
    }

    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation("upload-file")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        File returnFile = null;
        try {
            File f = transformFile(file);
            returnFile = fileService.saveFile(f);
            String path = "//" + fileServerHost + ":" + serverPort + "/file/view/" + returnFile.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/image")
    @ApiOperation("upload-image")
    public ResponseEntity<String> headUpload(@RequestParam("filepath") String filepath, @RequestParam("file") MultipartFile file) {
        File returnFile = null;
        try {
            File f = transformFile(file);
            f.setPath(filepath);
            returnFile = fileService.saveFile(f);
            String path = "//" + fileServerHost + ":" + serverPort + "/file/view/" + returnFile.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }


    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation("delete")
    public ResponseEntity<String> deleteFile(@PathVariable String id) {

        try {
            fileService.removeFile(id);
            return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    private File transformFile(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        File f = new File();
        f.setName(file.getOriginalFilename());
        f.setContentType(file.getContentType());
        f.setSize(file.getSize());
        f.setContent(new Binary(file.getBytes()));
        f.setMd5(MD5Util.getMD5(file.getInputStream()));
        return f;
    }
}

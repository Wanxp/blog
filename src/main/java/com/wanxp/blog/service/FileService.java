package com.wanxp.blog.service;

import com.wanxp.blog.model.File;

import java.util.List;
import java.util.Optional;

public interface FileService {
    /**
     * 保存文件
     * @param file
     * @return
     */
    File saveFile(File file);


    /**
     * 删除文件
     * @param id
     */
    void removeFile(String id);

    /**
     * 通过id获取文件
     * @param id
     * @return
     */
    Optional<File> getFileById(String id);


    /**
     * 分页查询文件
     * @param pageIdex
     * @param pageSize
     * @return
     */
    List<File> listFilesByPage(Integer pageIdex, Integer pageSize);


    /**
     * 通过id获取文件
     * @param path
     * @param name
     * @return
     */
    Optional<File> getFileByPathAndName(String path, String name);



}

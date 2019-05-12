package com.wanxp.blog.controller;

import com.wanxp.blog.extension.markdown.MarkDownTranslator;
import com.wanxp.blog.model.dto.CommentDTO;
import com.wanxp.blog.model.dto.ContentDTO;
import com.wanxp.blog.model.dto.ContentListDTO;
import com.wanxp.blog.model.vo.CommentVO;
import com.wanxp.blog.model.vo.ContentVO;
import com.wanxp.blog.service.CommentService;
import com.wanxp.blog.service.ContentListService;
import com.wanxp.blog.service.ContentService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class IndexController extends BaseController{

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentListService contentListService;
    @Autowired
    private CommentService commentService;

    @GetMapping( "/index")
    public String index(Model model) throws IOException {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "updatetime");
        Page contentPage = contentService.queryInPage(pageRequest);
        List<ContentListDTO> contentList=contentListService.queryInPage(pageRequest);
        List<ContentDTO> contentDTOList = contentPage.getContent();
        List<ContentVO> contentVOS = new ArrayList<>();
        if (contentDTOList != null && !contentDTOList.isEmpty()) {
            contentDTOList.stream().forEach(contentDTO -> {
                ContentVO contentVO = new ContentVO();
                BeanUtils.copyProperties(contentDTO, contentVO);
                contentVO.setContent(MarkDownTranslator.handle(contentDTO.getContent()));
                contentVOS.add(contentVO);
            });
        }
        PageRequest pageRequest2 = PageRequest.of(0, 5, Sort.Direction.DESC, "updatetime");
        Page commentPage = commentService.queryInPage(pageRequest2);
        List<CommentDTO> commentDTOS = commentPage.getContent();
        List<CommentVO> commentVOS = new ArrayList<>();
        if (commentDTOS != null && !commentDTOS.isEmpty()) {
            commentDTOS.stream().forEach(commentDTO -> {
                CommentVO commentVO = new CommentVO();
                BeanUtils.copyProperties(commentDTO, commentVO);
                commentVOS.add(commentVO);
            });
        }

        PageRequest pageRequest3 = PageRequest.of(0, 5, Sort.Direction.DESC, "updatetime");
        Page contentPage2 = contentService.queryInPage(pageRequest3);
        List<ContentDTO> contentDTOList2 = contentPage2.getContent();
        List<ContentVO> contentVOS2 = new ArrayList<>();
        if (contentDTOList2 != null && !contentDTOList2.isEmpty()) {
            contentDTOList2.stream().forEach(contentDTO -> {
                ContentVO contentVO = new ContentVO();
                BeanUtils.copyProperties(contentDTO, contentVO);
                contentVOS2.add(contentVO);
            });
        }

        model.addAttribute("contentList", contentVOS);
        model.addAttribute("lastCommentList", commentVOS);
        model.addAttribute("lastContentList", contentVOS2);
        model.addAttribute("logined", true);
        model.addAttribute("title", "sYsBlog");
        return "/index";
    }
    @RequestMapping("/online")
    @ResponseBody
    public String number(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        try{  //把sessionId记录在浏览器
            Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(httpServletRequest.getSession().getId(), "utf-8"));
            c.setPath("/");
            //先设置cookie有效期为2天，不用担心，session不会保存2天
            c.setMaxAge( 48*60 * 60);
            httpServletResponse.addCookie(c);
        }catch (Exception e){
            e.printStackTrace();
        }
 
        HttpSession session = httpServletRequest.getSession();
        Object count=session.getServletContext().getAttribute("count");
        return "count : "+count;
    }
}

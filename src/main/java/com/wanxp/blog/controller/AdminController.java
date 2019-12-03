package com.wanxp.blog.controller;

import com.wanxp.blog.model.dto.ContentDTO;
import com.wanxp.blog.model.vo.StatisticsVO;
import com.wanxp.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.wanxp.blog.constant.BlogConst.BLOG_TITLE;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ContentService contentService;

    //TODO 权限
    @GetMapping("index")
    @PreAuthorize("hasAnyAuthority(admin)")
    public String index(Model model, HttpServletRequest request) {

        Page<ContentDTO> contentDTOList = contentService.listByAuthor(1);
        model.addAttribute("title", BLOG_TITLE);
        model.addAttribute("statistics", new StatisticsVO(0, 0, 0));
        model.addAttribute("articles", contentDTOList.getContent());
        model.addAttribute("logs", new ArrayList<>());
        model.addAttribute("plugin_menus", null);
        return "/admin/index";
    }

}

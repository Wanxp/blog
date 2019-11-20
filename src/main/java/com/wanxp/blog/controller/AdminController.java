package com.wanxp.blog.controller;

import com.wanxp.blog.model.vo.StatisticsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.wanxp.blog.constant.BlogConst.BLOG_TITLE;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("title", BLOG_TITLE);
        model.addAttribute("statistics", new StatisticsVO(0, 0, 0));
        model.addAttribute("articles", null);
        model.addAttribute("components", null);
        model.addAttribute("logs", null);
        model.addAttribute("plugin_menus", null);
        model.addAttribute("components", null);
        model.addAttribute("components", null);
        return "/admin/index";
    }

}

package com.wanxp.blog.controller;

import com.wanxp.blog.model.dto.PlatformResult;
import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.model.vo.UserVO;
import com.wanxp.blog.service.UserService;
import com.wanxp.blog.util.MyBeanUtils;
import com.wanxp.blog.validation.groups.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.wanxp.blog.constant.BlogConst.BLOG_TITLE;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("title", BLOG_TITLE);
        model.addAttribute("statistics", null);
        model.addAttribute("articles", null);
        model.addAttribute("components", null);
        model.addAttribute("logs", null);
        model.addAttribute("plugin_menus", null);
        model.addAttribute("components", null);
        model.addAttribute("components", null);
        return "/admin/index";
    }

}

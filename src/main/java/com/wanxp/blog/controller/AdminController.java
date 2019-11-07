package com.wanxp.blog.controller;

import com.wanxp.blog.model.dto.PlatformResult;
import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.model.vo.UserVO;
import com.wanxp.blog.service.UserService;
import com.wanxp.blog.util.MyBeanUtils;
import com.wanxp.blog.validation.groups.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

}

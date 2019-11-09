package com.wanxp.blog.controller;

import com.wanxp.blog.model.dto.PlatformResult;
import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.model.vo.UserVO;
import com.wanxp.blog.service.UserService;
import com.wanxp.blog.util.MyBeanUtils;
import com.wanxp.blog.validation.groups.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping("loginPage")
    public String getLoginPage() {
        return "user/loginPage";
    }

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    @PostMapping
    @ResponseBody
    public PlatformResult login(@Validated({Login.class}) @ModelAttribute("form") UserVO user, HttpServletRequest request) {
        HttpSession session =  request.getSession();
        UserDTO sessionUser = (UserDTO) session.getAttribute("user" );
        PlatformResult json = new PlatformResult();
        UserDTO userDTO = new UserDTO();
        MyBeanUtils.copyProperties(user, userDTO);
        userDTO = userService.login(userDTO) ;
        if (userDTO == null) {
            json.setMsg("username not exist or password wrong");
            json.setSuccess(false);
        }else {
            if (sessionUser != null) {
                session.setAttribute("user", userDTO);
            }
        }
        return json;
    }

}

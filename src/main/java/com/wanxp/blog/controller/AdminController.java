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


    /**
     * 跳转到User管理页面
     *
     * @return
     */
    @GetMapping("/loginPage")
    public String manager(HttpServletRequest request) {
        return "/admin/loginPage";
    }

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public PlatformResult login(@Validated({Login.class}) @RequestBody UserVO user, HttpServletRequest request) {
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
            json.setSuccess(true);
            json.setMsg("success");
            json.setObj(userDTO);
        }
        return json;
    }

}

package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.model.dto.*;
import com.wanxp.blog.model.vo.UserVO;
import com.wanxp.blog.service.UserService;
import com.wanxp.blog.util.MyBeanUtils;
import com.wanxp.blog.validation.groups.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;


	/**
	 * 跳转到User管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/user/user";
	}

	/**
	 * 获取User数据表格
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/page")
	public Page dataGrid(UserDTO user, Pageable ph) {
		return userService.queryInPage(user, ph);
	}
	/**
	 * 获取User数据表格excel
	 * 
	 * @param user
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	@GetMapping("/download")
	public void download(UserDTO user, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(user,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加User页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		UserDTO user = new UserDTO();
		return "/user/userAdd";
	}

	/**
	 * 添加User
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public PlatformResult add(UserDTO user) {
		PlatformResult j = new PlatformResult();
		userService.add(user);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到User查看页面
	 * 
	 * @return
	 */
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		UserDTO user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userView";
	}

	/**
	 * 跳转到User修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		UserDTO user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userEdit";
	}

	/**
	 * 修改User
	 * 
	 * @param user
	 * @return
	 */
	@PutMapping("/edit")
	public PlatformResult edit(UserDTO user) {
		PlatformResult j = new PlatformResult();
		userService.edit(user);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除User
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public PlatformResult delete(@PathVariable Integer id) {
		PlatformResult j = new PlatformResult();
		userService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}



}

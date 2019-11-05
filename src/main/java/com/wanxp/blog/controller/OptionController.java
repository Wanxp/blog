package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.model.dto.*;
import com.wanxp.blog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Option管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/option")
public class OptionController extends BaseController {

	@Autowired
	private OptionService optionService;


	/**
	 * 跳转到Option管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/option/option";
	}

	/**
	 * 获取Option数据表格
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(OptionDTO option, Pageable pa) {
		return optionService.queryInPage(option, pa);
	}
	/**
	 * 获取Option数据表格excel
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
	public void download(OptionDTO option, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(option,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Option页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		OptionDTO option = new OptionDTO();
		return "/option/optionAdd";
	}

	/**
	 * 添加Option
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public PlatformResult add(OptionDTO option) {
		PlatformResult j = new PlatformResult();
		optionService.add(option);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到Option查看页面
	 * 
	 * @return
	 */
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		OptionDTO option = optionService.get(id);
		request.setAttribute("option", option);
		return "/option/optionView";
	}

	/**
	 * 跳转到Option修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		OptionDTO option = optionService.get(id);
		request.setAttribute("option", option);
		return "/option/optionEdit";
	}

	/**
	 * 修改Option
	 * 
	 * @param option
	 * @return
	 */
	@PutMapping("/edit")
	public PlatformResult edit(OptionDTO option) {
		PlatformResult j = new PlatformResult();
		optionService.edit(option);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除Option
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public PlatformResult delete(@PathVariable Integer id) {
		PlatformResult j = new PlatformResult();
		optionService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

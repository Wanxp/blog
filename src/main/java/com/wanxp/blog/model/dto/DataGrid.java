package com.wanxp.blog.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * @author John
 * 
 */
@Data
public class DataGrid {
	private Long total = 0L;
	private List rows = new ArrayList();
	private List footer = new ArrayList();
}

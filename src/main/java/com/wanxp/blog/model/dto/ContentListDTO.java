package com.wanxp.blog.model.dto;

import java.util.Date;

import com.wanxp.blog.constant.Icon;


public class ContentListDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 159204320145476338L;
	
	private String title;//标题
	private String categories;//
	private String words_info;//
	private String forward;//内容
	private Integer like_count;//
	private String user_name;//作者
	private String img_url;//图片路径
	private String create_time;	
    private Date updatetime;//更新时间
	private Integer id;//id主键
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIconClassName() {
		return Icon.getICON(this.categories).getIconClassName();
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getWords_info() {
		return words_info;
	}
	public void setWords_info(String words_info) {
		this.words_info = words_info;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public Integer getLike_count() {
		return like_count;
	}
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}

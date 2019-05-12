/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "sys_content_list")
@DynamicInsert(true)
@DynamicUpdate(true)
public class ContentList implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//alias
	public static final String TABLE_ALIAS = "Content";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_SLUG = "slug";
	public static final String ALIAS_THUMB_IMG = "thumbImg";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_MODIFIED = "modified";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_AUTHOR_ID = "authorId";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_FMT_TYPE = "fmtType";
	public static final String ALIAS_TAGS = "tags";
	public static final String ALIAS_CATEGORIES = "categories";
	public static final String ALIAS_HITS = "hits";
	public static final String ALIAS_COMMENTS_NUM = "commentsNum";
	public static final String ALIAS_ALLOW_COMMENT = "allowComment";
	public static final String ALIAS_ALLOW_PING = "allowPing";
	public static final String ALIAS_ALLOW_FEED = "allowFeed";
	
	//date formats
	public static final String FORMAT_ADDTIME = com.wanxp.blog.util.Constants.DATE_FORMAT_FOR_ENTITY;
	public static final String FORMAT_UPDATETIME = com.wanxp.blog.util.Constants.DATE_FORMAT_FOR_ENTITY;
	  
	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/  

	private Integer id;//id主键
	private String title;//标题
	private String categories;//
	private String words_info;//
	private String forward;//内容
	private Integer like_count;//
	private String user_name;//作者
	private String img_url;//图片路径
	private Date updatetime;//更新时间
	private String create_time;	
	
	public void setId(Integer id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	public Integer getId() {
		return this.id;
	}
	@Column(name = "words_info", unique = false, nullable = true, length = 10)
	public String getWords_info() {
		return words_info;
	}
	@Column(name = "updatetime", unique = false, nullable = true, length = 10)
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public void setWords_info(String words_info) {
		this.words_info = words_info;
	}
	@Column(name = "title", unique = false, nullable = true, length = 10)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "categories", unique = false, nullable = true, length = 10)
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	@Column(name = "forward", unique = false, nullable = true, length = 10)
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	@Column(name = "like_count", unique = false, nullable = true, length = 10)
	public Integer getLike_count() {
		return like_count;
	}
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}
	@Column(name = "user_name", unique = false, nullable = true, length = 10)
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Column(name = "img_url", unique = false, nullable = true, length = 10)
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Column(name = "create_time", unique = false, nullable = true, length = 10)
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}


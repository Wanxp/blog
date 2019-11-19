package com.wanxp.blog.model.dto;

/**
 * 
 * JSON模型
 * 
 * 用户后台向前台返回的JSON对象
 * 
 * @author John
 * 
 */
public class PlatformResult {

	private boolean success = true;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public static PlatformResult success() {
		PlatformResult platformResult = new PlatformResult();
		platformResult.setSuccess(Boolean.TRUE);
		return platformResult;
	}

	public static PlatformResult success(Object o) {
		PlatformResult platformResult = new PlatformResult();
		platformResult.setSuccess(Boolean.TRUE);
		platformResult.setObj(o);
		return platformResult;
	}

	public static PlatformResult success(String message) {
		PlatformResult platformResult = new PlatformResult();
		platformResult.setSuccess(Boolean.TRUE);
		platformResult.setMsg(message);
		return platformResult;
	}

	public static PlatformResult success(Object o, String message) {
		PlatformResult platformResult = new PlatformResult();
		platformResult.setSuccess(Boolean.TRUE);
		platformResult.setObj(o);
		platformResult.setMsg(message);
		return platformResult;
	}
}

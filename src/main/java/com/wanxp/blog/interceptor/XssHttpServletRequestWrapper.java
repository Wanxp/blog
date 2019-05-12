package com.wanxp.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	HttpServletRequest orgRequest = null;

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		orgRequest = request;
	}

	/**
	 * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
	 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = new HashMap<String, String[]>(super.getParameterMap());
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			if (values == null || values.length == 0) continue;
			for (int i = 0; i < values.length; i++) {
				values[i] = xssEncode(values[i]);
			}
			map.put(key, values);
		}
		return map;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(xssEncode(name));
		if(values != null) {
			for(int i = 0; i < values.length; i++) {
				values[i] = xssEncode(values[i]);
			}
		}
		return values;
	}

	@Override
	public String getRequestURI() {
		return xssEncode(super.getRequestURI());
	}

	@Override
	public StringBuffer getRequestURL() {
		return new StringBuffer(xssEncode(super.getRequestURL().toString()));
	}

	/**
	 * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
	 * getHeaderNames 也可能需要覆盖
	 */
	@Override
	public String getHeader(String name) {

		String value = super.getHeader(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	private static String xssEncode(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
//			case '\'':
//				sb.append('‘');// 全角单引号(暂不能过滤，Ajax好多arg[""]以这种方式传参，会过滤掉)
//				sb.append("");// 全角单引号(暂不能过滤，Ajax好多arg[""]以这种方式传参，会过滤掉)
//				break;
			case '\"':
				sb.append('\'');// 全角双引号(暂不能过滤，Ajax好多arg[""]以这种方式传参，会过滤掉)
//				sb.append("");// 全角双引号(暂不能过滤，Ajax好多arg[""]以这种方式传参，会过滤掉)
				break;
			case '&':
				sb.append('＆');// 全角
				break;
			case '\\':
				sb.append('＼');// 全角斜线
				break;
			case '#':
				sb.append('＃');// 全角井号
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 获取最原始的request
	 *
	 * @return
	 */
	public HttpServletRequest getOrgRequest() {
		return orgRequest;
	}

	/**
	 * 获取最原始的request的静态方法
	 *
	 * @return
	 */
	public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
		if (req instanceof XssHttpServletRequestWrapper) {
			return ((XssHttpServletRequestWrapper) req).getOrgRequest();
		}
		return req;
	}
}
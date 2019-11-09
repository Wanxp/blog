package com.wanxp.blog.component;


import java.util.Date;

import static com.wanxp.blog.constant.BlogConst.SITE_URL;

public class ThymeleafComponent {

    public String site_url() {
        return SITE_URL;
    }

    public String site_url(String url) {
        return SITE_URL + url;
    }

    public String fmtdate(Date date, String parttern) {
        //TODO
        return "2019-11-11 11:10:10";
    }

    public String article(String content) {
        //TODO
        return content;

    }

    public String gravatar(String str) {
        //TODO
        return str;
    }

    public String theme_url(String uri) {
        return uri;
    }
}

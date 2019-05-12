package com.wanxp.blog.constant;

public class BlogConst {
    /**
     * 插件菜单 Attribute Name
     */
    public static final String PLUGINS_MENU_NAME = "plugin_menus";

    public static final String ENV_SUPPORT_163_MUSIC = "app.support_163_music";
    public static final String ENV_SUPPORT_GIST      = "app.support_gist";
    public static final String MP3_PREFIX            = "[mp3:";
    public static final String MUSIC_IFRAME          = "<iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=350 height=106 src=\"//music.163.com/outchain/player?type=2&id=$1&auto=0&height=88\"></iframe>";
    public static final String MUSIC_REG_PATTERN     = "\\[mp3:(\\d+)\\]";
    public static final String GIST_PREFIX_URL       = "https://gist.github.com/";
    public static final String GIST_REG_PATTERN      = "&lt;script src=\"https://gist.github.com/(\\w+)/(\\w+)\\.js\">&lt;/script>";
    public static final String GIST_REPLATE_PATTERN  = "<script src=\"https://gist.github.com/$1/$2\\.js\"></script>";
}

package com.wanxp.blog.extension.markdown;

import com.wanxp.blog.constant.BlogConst;
import com.youbenzi.mdtool.tool.MDTool;
//import org.pegdown.PegDownProcessor;
import org.springframework.util.StringUtils;


public class MarkDownTranslator {
    public static String handle(String markdown) {
        if (StringUtils.isEmpty(markdown)) {
            return "";
        }
//        String content = new PegDownProcessor().markdownToHtml(markdown);
        String content = MDTool.markdown2Html(markdown);


        // 支持网易云音乐输出
        if (content.contains(BlogConst.MP3_PREFIX)) {
            content = content.replaceAll(BlogConst.MUSIC_REG_PATTERN, BlogConst.    MUSIC_IFRAME);
        }
        // 支持gist代码输出
        if (content.contains(BlogConst.    GIST_PREFIX_URL)) {
            content = content.replaceAll(BlogConst. GIST_REG_PATTERN, BlogConst .GIST_REPLATE_PATTERN);
        }
        return content;
    }
}

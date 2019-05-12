;-- 创建数据库
create database `blog` character set utf8mb4 collate utf8mb4_unicode_ci;
INSERT INTO content (id, title, slug, created, modified, content, author_id, type, status, tags, categories, hits, comments_num, allow_comment, allow_ping, allow_feed,addtime,updatetime,tenant_id,isdeleted) VALUES (1, '关于', 'about', 1487853610, 1487872488, '### Hello World

这是我的关于页面

### 当然还有其他

具体你来写点什么吧', 1, 'page', 'publish', NULL, NULL, 0, 0, 1, 1, 1,'2018-10-11 11:11:10', '2018-10-11 11:11:10', 1, 0);
INSERT INTO content (id, title, slug, created, modified, content, author_id, type, status, tags, categories, hits, comments_num, allow_comment, allow_ping, allow_feed,addtime,updatetime,tenant_id,isdeleted) VALUES (2, '第一篇文章', NULL, 1487861184, 1487872798, '## Hello  World.

> 第一篇文章总得写点儿什么?...

----------


<!--more-->

```java
public static void main(String[] args){
    System.out.println(\"Hello Tale.\");
}
```', 1, 'post', 'publish', '', '默认分类', 10, 0, 1, 1, 1,'2018-10-11 11:11:10', '2018-10-11 11:11:10', 1, 0);

INSERT INTO content (allow_feed,allow_ping,allow_comment,comments_num,hits,
categories,tags,fmt_type,status,type,author_id,content,modified,created,thumb_img,slug,title,id,addtime,updatetime,tenant_id,isdeleted) VALUES (
NULL,1,1,0,0,NULL,NULL,'markdown','publish','page',1,'## 友情链接

- :lock: [前端ui参照的是tale博客]()
- :lock: [cyang.tech]()
- :lock: [Bakumon''s Blog]()

## 链接须知

> 请确定贵站可以稳定运营
> 原创博客优先，技术类博客优先，设计、视觉类博客优先
> 经常过来访问和评论，眼熟的

备注：默认申请友情链接均为内页（当前页面）

## 基本信息

请在当页通过评论来申请友链，其他地方不予回复

暂时先这样，同时欢迎互换友链，这个页面留言即可。 ^_^

还有，我会不定时对无法访问的网址进行清理，请保证自己的链接长期有效。',1505643888,1505643727,NULL,'links','友情链接',3,'2018-10-11 11:11:10', '2018-10-11 11:11:10', 1, 0);

INSERT INTO blog.user (id, activated, addtime, created, email, group_name, home_url, isdeleted, logged, password, screen_name, tenant_id, updatetime, username) VALUES (1, 1, '2019-03-02 09:47:50', 1, '123456@qq.com', null, 'www.baidu.com', false, 1, '25f9e794323b453885f5181f1b624d0b', 'zhangsan', 1, '2019-03-02 09:49:13', 'wanxp123456');


INSERT INTO blog.comment (id, addtime, agent, author, author_id, cid, content, created, ip, isdeleted, mail, owner_id, parent, status, tenant_id, type, updatetime, url) VALUES (1, '2019-03-05 13:07:14', '1', 'wanxp', 1, 1, '你好,我是评论1', 1, '192.168.2.2', false, '977741432@qq.com', 1, null, '0', 1, '1', '2019-03-05 13:09:16', 'www.baidu.com');
INSERT INTO blog.comment (id, addtime, agent, author, author_id, cid, content, created, ip, isdeleted, mail, owner_id, parent, status, tenant_id, type, updatetime, url) VALUES (2, '2019-03-05 13:07:14', '1', 'wanxp', 1, 1, '你好,我是评论2', 1, '192.168.2.2', false, '977741432@qq.com', 1, 1, '0', 1, '1', '2019-03-05 13:09:16', 'www.baidu.com');
INSERT INTO blog.comment (id, addtime, agent, author, author_id, cid, content, created, ip, isdeleted, mail, owner_id, parent, status, tenant_id, type, updatetime, url) VALUES (3, '2019-03-05 13:07:14', '1', 'wanxp', 1, 1, '你好,我是评论3', 1, '192.168.2.2', false, '977741432@qq.com', 1, 2, '0', 1, '1', '2019-03-05 13:09:16', 'www.baidu.com');
INSERT INTO blog.comment (id, addtime, agent, author, author_id, cid, content, created, ip, isdeleted, mail, owner_id, parent, status, tenant_id, type, updatetime, url) VALUES (4, '2019-03-05 13:07:14', '1', 'wanxp', 1, 1, '你好,我是评论4', 1, '192.168.2.2', false, '977741432@qq.com', 1, 1, '0', 1, '1', '2019-03-05 13:09:16', 'www.baidu.com');
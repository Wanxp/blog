package com.wanxp.blog.model.vo;

import java.util.List;

public class CommentList<T> {
    private List<T> comments;
    private Boolean hasPrevPage;
    private Boolean hasNextPage;
    private Integer navPageNums;


    public List<T> getComments() {
        return comments;
    }

    public void setComments(List<T> comments) {
        this.comments = comments;
    }

    public Boolean getHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasPrevPage(Boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Integer getNavPageNums() {
        return comments == null ? 0 : comments.size();
    }

    public void setNavPageNums(Integer navPageNums) {
        this.navPageNums = navPageNums;
    }
}

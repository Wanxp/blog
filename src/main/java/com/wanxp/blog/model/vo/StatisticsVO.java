package com.wanxp.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsVO {
    private Integer articles;
    private Integer comments;
    private Integer attaches;
}

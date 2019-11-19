package com.wanxp.blog.model.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class File {
    @Id
    private String id;
    private String name;
    private String contentType;
    private Long size;
    private Date uploadDate;
    private String md5;
    private Binary content;
    private String path;
}

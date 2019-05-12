package com.wanxp.blog.repostory;

import com.wanxp.blog.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileRepository extends MongoRepository<File, String> {


    Optional<File> findFileByPathAndName(String path, String name);

}

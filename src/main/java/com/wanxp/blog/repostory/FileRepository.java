package com.wanxp.blog.repostory;

import com.wanxp.blog.model.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends MongoRepository<File, String> {


    Optional<File> findFileByPathAndName(String path, String name);

}

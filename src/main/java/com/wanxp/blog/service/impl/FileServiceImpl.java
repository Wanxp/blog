package com.wanxp.blog.service.impl;

import com.wanxp.blog.model.File;
import com.wanxp.blog.repostory.FileRepository;
import com.wanxp.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository repository;

    @Override
    public File saveFile(File file) {
        return repository.save(file);
    }

    @Override
    public void removeFile(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<File> getFileById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<File> listFilesByPage(Integer pageIndex, Integer pageSize) {
        Page<File> page = null;
        List<File> list = null;

        Sort sort = Sort.by(Sort.Direction.DESC,"uploadDate");
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);

        page = repository.findAll(pageable);
        list = page.getContent();
        return list;
    }

    @Override
    public Optional<File> getFileByPathAndName(String path, String name) {

        return repository.findFileByPathAndName(path, name);
    }
}

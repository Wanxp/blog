package com.wanxp.blog.service.impl;

import com.wanxp.blog.repostory.ContentRepository;
import com.wanxp.blog.model.Content;
import com.wanxp.blog.model.dto.ContentDTO;
import com.wanxp.blog.service.CommentService;
import com.wanxp.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository repostory;

	@Autowired
    private CommentService commentService;

    @Override
    public Page<ContentDTO> queryInPage(Pageable pa) {
        Page<Content> p = repostory.findAll(pa);
        List<ContentDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            ContentDTO d = new ContentDTO();
            copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<ContentDTO>(ds);
    }

    @Override
    public Page<ContentDTO> queryInPage(ContentDTO dto, Pageable pa) {
        return null;
    }

    @Override
    public void add(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public ContentDTO get(Integer id) {
        Content t = repostory.getOne(id);
        ContentDTO dto = new ContentDTO();
        if (t != null)
            copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }

    @Override
    public ContentDTO getAndCommentPage(Integer id, Pageable pageable) {
        ContentDTO contentDTO = get(id);
        if (contentDTO == null)
            return null;
        contentDTO.setCommentPage(commentService.getCommentPageByContentIdPageable(contentDTO.getId(), pageable));
        return contentDTO;
    }

}

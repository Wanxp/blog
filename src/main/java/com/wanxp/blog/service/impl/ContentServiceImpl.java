package com.wanxp.blog.service.impl;

import com.wanxp.blog.model.dto.CommentDTO;
import com.wanxp.blog.model.dto.ContentDTO;
import com.wanxp.blog.model.entity.Comment;
import com.wanxp.blog.model.entity.Content;
import com.wanxp.blog.repostory.CommentRepository;
import com.wanxp.blog.repostory.ContentRepository;
import com.wanxp.blog.service.ContentService;
import com.wanxp.blog.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.wanxp.blog.util.BeanUtils.copyProperties;


@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
    private ContentRepository contentRepository;

	@Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<ContentDTO> queryInPage(Pageable pa) {
        Page<Content> p = contentRepository.findAll(pa);
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
//        contentRepository.findByAttributeAndValue();
        return null;
    }

    @Override
    public Page<ContentDTO> listByAuthor(Integer authorId) {
        Page<Content> contentPage = contentRepository.findByAuthorId(authorId, Pageable.unpaged());
        return contentPage.map(x-> BeanUtils.copyProperties(x, ContentDTO.class));
    }

    @Override
    public void add(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        contentRepository.saveAndFlush(t);
    }

    @Override
    public ContentDTO get(Integer id) {
        Content t = contentRepository.getOne(id);
        ContentDTO dto = new ContentDTO();
        if (t != null)
            copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        contentRepository.save(t);
    }

    @Override
    public void delete(Integer id) {
        contentRepository.deleteById(id);
    }

    @Override
    public ContentDTO getAndCommentPage(Integer id, Pageable pageable) {
        ContentDTO contentDTO = get(id);
        Page<Comment> commentPage = commentRepository.findByCid(contentDTO.getId(), pageable);
        contentDTO.setCommentPage(commentPage.map(x-> copyProperties(x, CommentDTO.class)));
        return contentDTO;
    }

}

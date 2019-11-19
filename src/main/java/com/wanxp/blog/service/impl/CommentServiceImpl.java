package com.wanxp.blog.service.impl;

import com.wanxp.blog.repostory.CommentRepository;
import com.wanxp.blog.model.entity.Comment;
import com.wanxp.blog.model.dto.CommentDTO;
import com.wanxp.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository repostory;

    @Override
    public Page<CommentDTO> queryInPage(Pageable pa) {
        Page<Comment> p = repostory.findAll(pa);
        List<CommentDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            CommentDTO d = new CommentDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<CommentDTO>(ds);
    }


    @Override
    public Page<CommentDTO> queryInPage(CommentDTO dto, Pageable pa) {
        Page<Comment> p = repostory.findAll(pa);
        List<CommentDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            CommentDTO d = new CommentDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<CommentDTO>(ds);
    }

    @Override
    public void add(CommentDTO dto) {
        Comment t = new Comment();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public CommentDTO get(Integer id) {
        Comment t = repostory.getOne(id);
        CommentDTO dto = new CommentDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(CommentDTO dto) {
        Comment t = new Comment();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }

    @Override
    public Page<CommentDTO> getCommentPageByContentIdPageable(Integer contentId, Pageable pageable) {
        Page<Comment> commentPage = repostory.findByCid(contentId, pageable);
        System.out.println(commentPage.getContent().toString());
        return commentPage.map((comment) -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            return commentDTO;
        });
    }

}

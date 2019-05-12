package com.wanxp.blog.service.impl;

import com.wanxp.blog.repostory.ContentListRepository;
import com.wanxp.blog.model.ContentList;
import com.wanxp.blog.model.dto.ContentListDTO;
import com.wanxp.blog.service.ContentListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ContentListServiceImpl implements ContentListService {

	@Autowired
	private ContentListRepository repostory;

    @Override
    public List<ContentListDTO> queryInPage(Pageable pa) {
        Page<ContentList> p = repostory.findAll(pa);
        List<ContentListDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
        	ContentListDTO d = new ContentListDTO();
            copyProperties(x, d);
            ds.add(d);
        });
        return ds;
    }

}

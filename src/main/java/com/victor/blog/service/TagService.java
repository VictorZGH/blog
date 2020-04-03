package com.victor.blog.service;

import com.victor.blog.bean.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Tag getByName(String name);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
    Page<Tag> listPage(Pageable pageable);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    List<Tag> listTagTop(Integer size);
}

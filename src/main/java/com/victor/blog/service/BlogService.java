package com.victor.blog.service;

import com.victor.blog.bean.Blog;
import com.victor.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog getBlog(Long id);

    Blog getBlogAndConvert(Long id);

    Blog saveBlog(Blog blog);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    List<Blog> listRecommendBlog(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    Blog update(Long id, Blog blog);

    void delete(Long id);
}

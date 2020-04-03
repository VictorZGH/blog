package com.victor.blog.dao;

import com.victor.blog.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
    @Query("SELECT b FROM Blog b WHERE b.recommend=true")
    List<Blog> findTop(Pageable pageable);

    @Query("SELECT b FROM Blog b WHERE b.title LIKE ?1 OR b.content LIKE ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Blog b SET b.views = b.views + 1 WHERE b.id = ?1")
    int updateViews(Long id);

    @Query("SELECT function('date_format', b.updateTime, '%Y') AS year FROM Blog b GROUP BY function('date_format', b.updateTime, '%Y') ORDER BY year DESC ")
    List<String> findGroupYear();

    @Query("SELECT b from Blog b WHERE function('date_format', b.updateTime, '%Y') = ?1")
    List<Blog> findByYear(String year);
}

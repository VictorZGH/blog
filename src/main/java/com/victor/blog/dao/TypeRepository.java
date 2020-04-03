package com.victor.blog.dao;

import com.victor.blog.bean.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    @Query("SELECT t FROM Type t")
    List<Type> findTopBy(Pageable pageable);
}

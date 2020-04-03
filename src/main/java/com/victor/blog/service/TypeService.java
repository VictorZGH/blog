package com.victor.blog.service;

import com.victor.blog.bean.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getByName(String name);

    Type updateType(Long id, Type type);

    List<Type> listTypeTop(Integer size);

    void deleteType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();
}

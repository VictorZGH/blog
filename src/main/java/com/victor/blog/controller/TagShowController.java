package com.victor.blog.controller;

import com.victor.blog.bean.Tag;
import com.victor.blog.bean.Type;
import com.victor.blog.service.BlogService;
import com.victor.blog.service.TagService;
import com.victor.blog.service.TypeService;
import com.victor.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 10,  sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id,
                        Model model){
        List<Tag> tags = tagService.listTagTop(1000);
        if(id == -1){
            id = tags.get(0).getId();
        }

        model.addAttribute("tags", tags).addAttribute("page", blogService.listBlog(id, pageable)).addAttribute("activeTypeId", id);
        return "tags";

    }

}

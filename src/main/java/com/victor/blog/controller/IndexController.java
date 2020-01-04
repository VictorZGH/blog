package com.victor.blog.controller;


import com.victor.blog.excpetion.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping(value = "/hello/{id}/{name}")
    public String index(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + name);

//        try{
//            int a = 9 / 0;
//        }catch (Exception e){
//            System.out.println(e.getCause());
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
//        }
        String blog = null;
        if(blog == null){
            throw new ServiceException("博客找不到");
        }
        return "index";
    }
}

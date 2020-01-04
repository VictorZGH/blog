package com.victor.blog.service;

import com.victor.blog.bean.User;

public interface UserService {

    User checkUser(String username, String password);
}

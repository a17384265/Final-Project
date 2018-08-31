package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */
public interface UserService {
    public void insert(User user);

    public List<User> queryAll();

    public User login(String name, String passowrd);

}

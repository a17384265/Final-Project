package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

@Component(value = "userDAO")
public interface UserDao {
    List<User> queryAll();

    void add(User user);

    public User queryByNameAndPassword(@Param("name") String name, @Param("password") String password);

}

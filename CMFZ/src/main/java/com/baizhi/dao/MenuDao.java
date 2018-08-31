package com.baizhi.dao;

import com.baizhi.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
@Component(value = "menuDAO")
public interface MenuDao {
    public List<Menu> showAll();
}

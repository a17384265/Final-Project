package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
@Controller
@RequestMapping("/Menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/showAll.do")
    @ResponseBody
    public List<Menu> Menu() {
        List<Menu> list = menuService.showAll();
        return list;
    }


}


package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by sea on 2018/8/28.
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping("/query.do")
    public String code(HttpSession session, String enCode) {
        String checkCode = (String) session.getAttribute("serverCode");
        if (checkCode.equalsIgnoreCase(enCode)) {
            return null;
        } else {
            return "验证码错误";
        }
    }

    @RequestMapping("/login.do")
    public ModelAndView login(HttpSession session, @RequestParam("name") String name, @RequestParam("password") String password, String enCode) {
        ModelAndView mv = new ModelAndView();
        String checkCode = (String) session.getAttribute("serverCode");
        if (checkCode.equalsIgnoreCase(enCode)) {
            User users = service.login(name, password);
            if (users == null) {
                mv.setViewName("redirect:/login.jsp");
                return mv;
            } else {
                session.setAttribute("name", name);
                mv.setViewName("redirect:/main/main.jsp");
                return mv;
            }
        } else {
            mv.setViewName("redirect:/login.jsp");
            return mv;
        }
    }
}

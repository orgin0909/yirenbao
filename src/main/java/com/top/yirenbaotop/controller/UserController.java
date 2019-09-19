package com.top.yirenbaotop.controller;

import com.top.yirenbaotop.domain.User;
import com.top.yirenbaotop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
     private UserService userService;

    //注册
    @RequestMapping("/register")
    public boolean register(User user, @RequestParam("phoneCode") String phoneCode, HttpSession session){
        String code = (String) session.getAttribute("code");
        if (!code.equals(phoneCode)){
            return false;
        }
        int fluRows =  userService.register(user);
        if (fluRows!=1){
            return false;
        }

        return true;
    }
    //判断用户名是否存在
    @RequestMapping("/loadByAccount")
    public boolean loadByAccount(@RequestParam("account") String account){
        User user = userService.loadByAccount(account);
        if(user==null){
            return false;
        }

        return true;
    }

    //登录
    @RequestMapping("/login")
    public boolean login(User user){
        User user1 = userService.login(user);
        if(user1==null){
            return false;
        }

        return true;
    }
}

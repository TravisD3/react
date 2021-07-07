package com.siyu.myhealthapp.controller;

// all the link if user want to


import com.siyu.myhealthapp.module.User;
import com.siyu.myhealthapp.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class loginCtrl{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam("username") String userName,
                            @RequestParam("password") String password,
                            Map<String,Object> map)
    {
        User user = userService.Login(userName,password);
        if(user == null) return "error/errors";

        map.put("user",user);

        return "success";
    }

    @GetMapping("/signup")
    public String gotoSignUp(Map<String,Object> map){
        List<User> list = userService.getAll();
        map.put("users",list);
        return "signup";
    }

    @PostMapping("/register")
    public ModelAndView register(User user, ModelAndView modelAndView){
        userService.add(user);

        modelAndView.setViewName("login");

        return modelAndView;

    }



}

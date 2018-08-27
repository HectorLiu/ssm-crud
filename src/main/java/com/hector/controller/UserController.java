package com.hector.controller;

import com.hector.dao.UserMapper;
import com.hector.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/")
    public List<User> index() {
       return userMapper.all();
    }
}

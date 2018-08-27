package com.hector.controller;

import com.hector.dao.UserMapper;
import com.hector.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public String index(Model model){
        List<User> users = userMapper.selectByExample(null);
        model.addAttribute("users", users);
        return "index";
    }
}

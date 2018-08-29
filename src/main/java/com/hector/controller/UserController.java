package com.hector.controller;

import com.hector.dao.UserMapper;
import com.hector.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("users")
    public String index() {
        return "user_list";
    }

    @ResponseBody
    @GetMapping("/api/users")
    public List<User> allUsers() {
        return userMapper.selectByExample(null);
    }

    @ResponseBody
    @PostMapping("/api/users")
    public String store(@RequestBody User user){
        userMapper.insertSelective(user);
        return "ok";
    }
    @ResponseBody
    @GetMapping("/api/users/{id}")
    public User show(@PathVariable("id") Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @ResponseBody
    @PutMapping("/api/users/{id}")
    public String update(@RequestBody User user){
        userMapper.updateByPrimaryKeySelective(user);
        return "ok";
    }

    @ResponseBody
    @DeleteMapping("/api/users/{id}")
    public String delete(@PathVariable Integer id){
        userMapper.deleteByPrimaryKey(id);
        return "ok";
    }
}

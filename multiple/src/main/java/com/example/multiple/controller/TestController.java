package com.example.multiple.controller;


import com.example.multiple.entity.Group;
import com.example.multiple.entity.User;
import com.example.multiple.mapper.d1.UserMapper;
import com.example.multiple.mapper.d2.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping("/getUser")
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @RequestMapping("/getGroup")
    public List<Group> getGroup() {
        return groupMapper.getGroup();
    }
}

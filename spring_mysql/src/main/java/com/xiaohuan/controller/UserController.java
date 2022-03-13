package com.xiaohuan.controller;

import java.util.HashMap;
import java.util.Map;

import com.xiaohuan.bean.User;
import com.xiaohuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id")String id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUser(id);
        modelMap.put("data", user);
        return modelMap;
    }

    @PostMapping(value = "add")
    public String insert(@RequestBody User user){
       return userService.addUser(user);
    }


}

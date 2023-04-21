package com.geekster.userManagementSystem.controller;


import com.geekster.userManagementSystem.model.UserManage;
import com.geekster.userManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControl {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getAllUsers")
    public List<UserManage> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody UserManage userManagement)
    {
        return userService.addMyUser(userManagement);
    }

    @GetMapping(value = "/getUserId/{id}")
    public UserManage getUserById(@PathVariable String id){
        return userService.getUserBasedId(id);
    }

    @PutMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable int id,@RequestBody UserManage userManagement){
        return userService.updateUser(id,userManagement);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUserById(@PathVariable String id){
        return userService.removeUserId(id);
    }
}


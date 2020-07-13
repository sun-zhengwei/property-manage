package com.property.manage.controller;

import com.property.manage.dao.model.User;
import com.property.manage.service.UserServiceImple;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoproject/test")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImple userService ;

    // @RequiresPermissions("user:show")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public User test(@PathVariable Integer id){
        System.out.println("id:" + id);
        User user = userService.getById(id);
        return user;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public User test1(@PathVariable Integer id){
        System.out.println("id:" + id);
        return userService.getById(id);
    }


}

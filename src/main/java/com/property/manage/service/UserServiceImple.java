package com.property.manage.service;

import com.property.manage.dao.mapper.UserMapper;
import com.property.manage.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple {

    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}

package com.property.manage.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.property.manage.dao.mapper.UserMapper;
import com.property.manage.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getUserList() {

        return userMapper.selectAll();
    }

    @Override
    public Page<User> getUserByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> userList= userMapper.getUserByPage();

        return userList;
    }
}

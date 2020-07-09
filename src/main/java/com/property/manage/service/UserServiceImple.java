package com.property.manage.service;

import com.property.manage.dao.mapper.UserDao;
import com.property.manage.dao.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple {

    @Autowired
    private UserDao userDao;

    public UserEntity getById(Integer id) {
        return userDao.getById(id);
    }
}

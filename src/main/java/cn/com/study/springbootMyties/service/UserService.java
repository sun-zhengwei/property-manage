package cn.com.study.springbootMyties.service;

import cn.com.study.springbootMyties.dao.UserDao;
import cn.com.study.springbootMyties.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao ;

    public UserEntity getById(Integer id){
        return userDao.getById(id);
    }
}

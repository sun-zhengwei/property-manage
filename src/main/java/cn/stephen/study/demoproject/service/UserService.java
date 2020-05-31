package cn.stephen.study.demoproject.service;

import cn.stephen.study.demoproject.dao.UserDao;
import cn.stephen.study.demoproject.entity.UserEntity;
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

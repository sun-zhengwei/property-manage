package com.property.manage.service;

import com.github.pagehelper.Page;
import com.property.manage.dao.model.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @description:
 * @author: sunzhengwei
 * @create: 2020/7/9 14:49
 */
public interface UserService {

    /**
     * 获取所有user
     * @return
     */
    List<User> getUserList();

    /**
     * 分页获取数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> getUserByPage(Integer pageNum, Integer pageSize);

}

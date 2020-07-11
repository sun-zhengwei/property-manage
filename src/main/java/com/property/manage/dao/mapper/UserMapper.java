package com.property.manage.dao.mapper;

import com.property.manage.annotation.MyBatisDao;
import com.property.manage.dao.model.User;

import java.util.List;

@MyBatisDao
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    List<User> selectAll();

    User getById(Integer id);
}
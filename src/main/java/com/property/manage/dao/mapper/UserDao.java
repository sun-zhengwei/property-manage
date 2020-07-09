package com.property.manage.dao.mapper;

import com.property.manage.dao.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserEntity getById(Integer id);

}

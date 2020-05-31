package cn.com.study.springbootMyties.dao;

import cn.com.study.springbootMyties.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserEntity getById(Integer id);

}

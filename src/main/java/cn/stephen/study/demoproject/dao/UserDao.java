package cn.stephen.study.demoproject.dao;

import cn.stephen.study.demoproject.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserEntity getById(Integer id);

}

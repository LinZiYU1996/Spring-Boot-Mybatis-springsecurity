package com.example.demo.mapper;

import com.example.demo.model.UserAndRole;

public interface UserAndRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndRole record);

    int insertSelective(UserAndRole record);

    UserAndRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndRole record);

    int updateByPrimaryKey(UserAndRole record);

    int setUserAdmin(Integer userID);

    int setUser(Integer userID);
}
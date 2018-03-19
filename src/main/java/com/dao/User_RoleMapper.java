package com.dao;

import com.entity.User_RoleKey;

public interface User_RoleMapper {
    int deleteByPrimaryKey(User_RoleKey key);

    int insert(User_RoleKey record);

    int insertSelective(User_RoleKey record);
}
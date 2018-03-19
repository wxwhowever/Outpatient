package com.dao;

import com.entity.Role_PowerKey;

public interface Role_PowerMapper {
    int deleteByPrimaryKey(Role_PowerKey key);

    int insert(Role_PowerKey record);

    int insertSelective(Role_PowerKey record);
}
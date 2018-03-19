package com.dao;

import com.entity.Power;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}
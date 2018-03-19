package com.dao;

import com.base.BaseDao;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao extends BaseDao<UserDao> {

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    User login(String name,String password);

    User shiroLogin(String name);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Map<String, Object>> queryPower(@Param("uid")Integer uid);
}

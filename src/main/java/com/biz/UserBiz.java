package com.biz;

import com.base.BaseBiz;
import com.entity.CK_wait;
import com.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserBiz extends BaseBiz<CK_wait>{

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    User login(String name, String password);


    /**
     * 查询权限
     * @param uid
     * @return
     */
    List<Map<String, Object>> queryPower(Integer uid);


    User shiroLogin(String name);
}

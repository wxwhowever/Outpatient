package com.biz.Imp;

import com.biz.Ck_waitBiz;
import com.biz.UserBiz;
import com.dao.Ck_waitDao;
import com.dao.UserDao;
import com.entity.CK_wait;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBizImp implements UserBiz {

    @Autowired
    UserDao userDao;


    public User login(String name, String password) {
        User user = userDao.login(name, password);
        return user;
    }

    public  List<Map<String, Object>> queryPower(Integer uid) {
        return userDao.queryPower(uid);
    }

    public User shiroLogin(String name) {
        return userDao.shiroLogin(name);
    }


    public Map<String, Object> queryMap(String sql, int begin, int end) {
        return null;
    }

    public List<CK_wait> queryList() {
        return null;
    }

    public List<CK_wait> queryLists(String sql, int begin, int end) {
        return null;
    }

    public CK_wait queryById(Serializable serializable) {
        return null;
    }

    public boolean insert(Object object) {
        return false;
    }

    public boolean update(Object object) {
        return false;
    }

    public boolean delete(Object object) {
        return false;
    }

    public int getCount(String sql) {
        return 0;
    }


}

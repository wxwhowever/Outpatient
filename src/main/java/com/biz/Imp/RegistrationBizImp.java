package com.biz.Imp;

import com.biz.RegistrationBiz;
import com.dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Registration;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegistrationBizImp implements RegistrationBiz {

    @Autowired
    RegistrationDao registrationDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Registration> list = registrationDao.queryLists(sql,begin,end);
        int maxCount = registrationDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Registration> queryList() {
        return registrationDao.queryList();
    }

    public List<Registration> queryLists(String sql, int begin, int end) {
        return registrationDao.queryLists(sql,begin,end);
    }

    public Registration queryById(Serializable serializable) {
        return registrationDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return registrationDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            registrationDao.insert(object);
            f = true;
        }catch (Exception e){
            f =false;
            e.printStackTrace();
        }
        return f;
    }

    public boolean update(Object object) {
        boolean f = false;
        try {
            registrationDao.update(object);
            f = true;
        }catch (Exception e){
            f =false;
            e.printStackTrace();
        }
        return f;
    }

    public boolean delete(Object object) {
        boolean f = false;
        try {
            registrationDao.delete(object);
            f = true;
        }catch (Exception e){
            f =false;
            e.printStackTrace();
        }
        return f;
    }

    public int getCount(String sql) {
        return 0;
    }
}

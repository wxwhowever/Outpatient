package com.biz.Imp;

import com.biz.DoctorcardBiz;
import com.dao.DoctorcardDao;
import com.entity.Doctorcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorcardBizImp implements DoctorcardBiz {

    @Autowired
    DoctorcardDao doctorcardDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Doctorcard> list = doctorcardDao.queryLists(sql,begin,end);
        int maxCount = doctorcardDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Doctorcard> queryList() {
        return doctorcardDao.queryList();
    }

    public List<Doctorcard> queryLists(String sql, int begin, int end) {
        return doctorcardDao.queryLists(sql,begin,end);
    }

    public Doctorcard queryById(Serializable serializable) {
        return doctorcardDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return doctorcardDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            doctorcardDao.insert(object);
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
            doctorcardDao.update(object);
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
            doctorcardDao.delete(object);
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

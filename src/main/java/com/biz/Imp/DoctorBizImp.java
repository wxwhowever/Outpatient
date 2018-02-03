package com.biz.Imp;

import com.biz.DoctorBiz;
import com.biz.DoctorcardBiz;
import com.dao.DoctorDao;
import com.dao.DoctorcardDao;
import com.entity.Doctor;
import com.entity.Doctorcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorBizImp implements DoctorBiz {

    @Autowired
    DoctorDao doctorDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Doctor> list = doctorDao.queryLists(sql,begin,end);
        int maxCount = doctorDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Doctor> queryList() {
        return doctorDao.queryList();
    }

    public List<Doctor> queryLists(String sql, int begin, int end) {
        return doctorDao.queryLists(sql,begin,end);
    }

    public Doctor queryById(Serializable serializable) {
        return doctorDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return doctorDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            doctorDao.insert(object);
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
            doctorDao.update(object);
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
            doctorDao.delete(object);
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

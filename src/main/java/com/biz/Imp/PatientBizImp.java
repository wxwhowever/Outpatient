package com.biz.Imp;

import com.biz.PatientBiz;
import com.dao.PatientDao;
import com.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientBizImp implements PatientBiz {

    @Autowired
    PatientDao patientDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Patient> list = patientDao.queryLists(sql,begin,end);
        int maxCount = patientDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Patient> queryList() {
        return patientDao.queryList();
    }

    public List<Patient> queryLists(String sql, int begin, int end) {
        return patientDao.queryLists(sql,begin,end);
    }

    public Patient queryById(Serializable serializable) {
        return patientDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return patientDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            patientDao.insert(object);
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
            patientDao.update(object);
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
            patientDao.delete(object);
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

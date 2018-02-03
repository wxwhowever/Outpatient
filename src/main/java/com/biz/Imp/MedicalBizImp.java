package com.biz.Imp;

import com.biz.MedicalBiz;
import com.dao.MedicalDao;
import com.entity.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicalBizImp implements MedicalBiz {

    @Autowired
    MedicalDao medicalDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Medical> list = medicalDao.queryLists(sql,begin,end);
        int maxCount = medicalDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Medical> queryList() {
        return medicalDao.queryList();
    }

    public List<Medical> queryLists(String sql, int begin, int end) {
        return medicalDao.queryLists(sql,begin,end);
    }

    public Medical queryById(Serializable serializable) {
        return medicalDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return medicalDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            medicalDao.insert(object);
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
            medicalDao.update(object);
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
            medicalDao.delete(object);
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

package com.biz.Imp;

import com.base.BaseBiz;
import com.biz.MedicalcardBiz;
import com.dao.MedicalcardDao;
import com.entity.Medicalcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicalcardBizImp implements MedicalcardBiz {

    @Autowired
    MedicalcardDao medicalcardDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Medicalcard> list = medicalcardDao.queryLists(sql,begin,end);
        int maxCount = medicalcardDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Medicalcard> queryList() {
        return medicalcardDao.queryList();
    }

    public List<Medicalcard> queryLists(String sql, int begin, int end) {
        return medicalcardDao.queryLists(sql,begin,end);
    }

    public Medicalcard QueryById(Serializable serializable) {
        return medicalcardDao.QueryById(serializable);
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            medicalcardDao.insert(object);
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
            medicalcardDao.update(object);
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
            medicalcardDao.delete(object);
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

package com.biz.Imp;

import com.biz.Diagnosis_ResultBiz;
import com.dao.Diagnosis_ResultDao;
import com.entity.Diagnosis_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Diagnosis_ResultBizImp implements Diagnosis_ResultBiz {

    @Autowired
    Diagnosis_ResultDao diagnosis_resultDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Diagnosis_result> list = diagnosis_resultDao.queryLists(sql,begin,end);
        int maxCount = diagnosis_resultDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }



    public List<Diagnosis_result> queryList() {
        return diagnosis_resultDao.queryList();
    }

    public List<Diagnosis_result> queryLists(String sql, int begin, int end) {
        return diagnosis_resultDao.queryLists(sql,begin,end);
    }

    public Diagnosis_result queryById(Serializable serializable) {
        return diagnosis_resultDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return diagnosis_resultDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            diagnosis_resultDao.insert(object);
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
            diagnosis_resultDao.update(object);
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
            diagnosis_resultDao.delete(object);
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

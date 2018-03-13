package com.biz.Imp;

import com.biz.DrugBiz;
import com.dao.DrugDao;
import com.entity.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrugBizImp implements DrugBiz {

    @Autowired
    DrugDao drugDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Drug> list = drugDao.queryLists(sql,begin,end);
        int maxCount = drugDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Drug> queryList() {
        return drugDao.queryList();
    }

    public List<Drug> queryLists(String sql, int begin, int end) {
        return drugDao.queryLists(sql,begin,end);
    }

    public Drug queryById(Serializable serializable) {
        return drugDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return drugDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            drugDao.insert(object);
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
            drugDao.update(object);
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
            drugDao.delete(object);
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

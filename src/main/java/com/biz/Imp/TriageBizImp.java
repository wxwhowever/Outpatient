package com.biz.Imp;

import com.biz.TriageBiz;
import com.dao.TriageDao;
import com.entity.Triage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TriageBizImp implements TriageBiz {

    @Autowired
    TriageDao triageDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Triage> list = triageDao.queryLists(sql,begin,end);
        int maxCount = triageDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Triage> queryList() {
        return triageDao.queryList();
    }

    public List<Triage> queryLists(String sql, int begin, int end) {
        return triageDao.queryLists(sql,begin,end);
    }

    public Triage queryById(Serializable serializable) {
        return triageDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return triageDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            triageDao.insert(object);
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
            triageDao.update(object);
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
            triageDao.delete(object);
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

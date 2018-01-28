package com.biz.Imp;

import com.biz.MedicarecardBiz;
import com.dao.MedicarecardDao;
import com.entity.Medicarecard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicarecardBizImp implements MedicarecardBiz {

    @Autowired
    MedicarecardDao medicarecardDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Medicarecard> list = medicarecardDao.queryLists(sql,begin,end);
        int maxCount = medicarecardDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Medicarecard> queryList() {
        return medicarecardDao.queryList();
    }

    public List<Medicarecard> queryLists(String sql, int begin, int end) {
        return medicarecardDao.queryLists(sql,begin,end);
    }

    public Medicarecard queryById(Serializable serializable) {
        return medicarecardDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return medicarecardDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            medicarecardDao.insert(object);
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
            medicarecardDao.update(object);
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
            medicarecardDao.delete(object);
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

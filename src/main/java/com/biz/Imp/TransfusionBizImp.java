package com.biz.Imp;

import com.biz.TransfusionBiz;
import com.dao.TransfusionDao;
import com.entity.Transfusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransfusionBizImp implements TransfusionBiz {

    @Autowired
    TransfusionDao transfusionDao;


    public List<Transfusion> resultMap(String param, int begin, int end) {
        return transfusionDao.resultMap(param, begin, end);
    }

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Transfusion> list = transfusionDao.queryLists(sql,begin,end);
        int maxCount = transfusionDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Transfusion> queryList() {
        return transfusionDao.queryList();
    }

    public List<Transfusion> queryLists(String sql, int begin, int end) {
        return transfusionDao.queryLists(sql, begin, end);
    }

    public Transfusion queryById(Serializable serializable) {
        return transfusionDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return transfusionDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return transfusionDao.insert(object);
    }

    public boolean update(Object object) {
        return transfusionDao.update(object);
    }

    public boolean delete(Object object) {
        return transfusionDao.delete(object);
    }

    public int getCount(String sql) {
        return transfusionDao.getCount(sql);
    }
}

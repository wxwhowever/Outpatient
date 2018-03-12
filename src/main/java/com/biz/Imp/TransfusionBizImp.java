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
    TransfusionDao TransfusionDao;


    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Transfusion> list = TransfusionDao.queryLists(sql,begin,end);
        int maxCount = TransfusionDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Transfusion> queryList() {
        return TransfusionDao.queryList();
    }

    public List<Transfusion> queryLists(String sql, int begin, int end) {
        return TransfusionDao.queryLists(sql, begin, end);
    }

    public Transfusion queryById(Serializable serializable) {
        return TransfusionDao.queryById(serializable);
    }

    public boolean insert(Object object) {
        return TransfusionDao.insert(object);
    }

    public boolean update(Object object) {
        return TransfusionDao.update(object);
    }

    public boolean delete(Object object) {
        return TransfusionDao.delete(object);
    }

    public int getCount(String sql) {
        return TransfusionDao.getCount(sql);
    }
}

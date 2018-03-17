package com.biz.Imp;

import com.biz.TreatBiz;
import com.dao.TreatDao;
import com.entity.Treat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreatBizImp implements TreatBiz {

    @Autowired
    TreatDao treatDao;


    public List<Treat> resultMap(String param, int begin, int end) {
        return treatDao.resultMap(param, begin, end);
    }

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Treat> list = treatDao.queryLists(sql,begin,end);
        int maxCount = treatDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Treat> queryList() {
        return treatDao.queryList();
    }

    public List<Treat> queryLists(String sql, int begin, int end) {
        return treatDao.queryLists(sql, begin, end);
    }

    public Treat queryById(Serializable serializable) {
        return treatDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return treatDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return treatDao.insert(object);
    }

    public boolean update(Object object) {
        return treatDao.update(object);
    }

    public boolean delete(Object object) {
        return treatDao.delete(object);
    }

    public int getCount(String sql) {
        return treatDao.getCount(sql);
    }
}

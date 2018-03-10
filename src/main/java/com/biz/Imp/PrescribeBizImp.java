package com.biz.Imp;

import com.biz.PrescribeBiz;
import com.dao.PrescribeDao;
import com.entity.Prescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrescribeBizImp implements PrescribeBiz {

    @Autowired
    PrescribeDao prescribeDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<Prescribe> list = prescribeDao.queryLists(sql,begin,end);
        int maxCount = prescribeDao.getCount(sql);
        int maxPage = (maxCount/end)+(maxCount%end!=0?1:0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Prescribe> queryList() {
        return prescribeDao.queryList();
    }

    public List<Prescribe> queryLists(String sql, int begin, int end) {
        return prescribeDao.queryLists(sql, begin, end);
    }

    public Prescribe queryById(Serializable serializable) {
        return prescribeDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return prescribeDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return prescribeDao.insert(object);
    }

    public boolean update(Object object) {
        return prescribeDao.update(object);
    }

    public boolean delete(Object object) {
        return prescribeDao.delete(object);
    }

    public int getCount(String sql) {
        return 0;
    }
}

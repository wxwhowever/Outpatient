package com.biz.Imp;

import com.biz.InjectdrugBiz;
import com.dao.InjectdrugDao;
import com.entity.Injectdrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InjectdrugBizImp implements InjectdrugBiz {

    @Autowired
    InjectdrugDao InjectdrugDao;


    public List<Injectdrug> resultMap(String param, int begin, int end) {
        return InjectdrugDao.resultMap(param, begin, end);
    }

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Injectdrug> list = InjectdrugDao.queryLists(sql,begin,end);
        int maxCount = InjectdrugDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Injectdrug> queryList() {
        return InjectdrugDao.queryList();
    }

    public List<Injectdrug> queryLists(String sql, int begin, int end) {
        return InjectdrugDao.queryLists(sql, begin, end);
    }

    public Injectdrug queryById(Serializable serializable) {
        return InjectdrugDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return InjectdrugDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return InjectdrugDao.insert(object);
    }

    public boolean update(Object object) {
        return InjectdrugDao.update(object);
    }

    public boolean delete(Object object) {
        return InjectdrugDao.delete(object);
    }

    public int getCount(String sql) {
        return InjectdrugDao.getCount(sql);
    }
}

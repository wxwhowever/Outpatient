package com.biz.Imp;

import com.biz.ZY_waitBiz;
import com.dao.ZY_waitDao;
import com.entity.ZY_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class ZY_waitBizImp implements ZY_waitBiz {

    @Autowired
    ZY_waitDao zy_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ZY_wait> list = zy_waitDao.queryLists(sql,begin,end);
        int maxCount = zy_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<ZY_wait> queryList() {
        return zy_waitDao.queryList();
    }

    public List<ZY_wait> queryLists(String sql, int begin, int end) {
        return zy_waitDao.queryLists(sql,begin,end);
    }

    public ZY_wait queryById(Serializable serializable) {
        return zy_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return zy_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            zy_waitDao.insert(object);
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
            zy_waitDao.update(object);
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
            zy_waitDao.delete(object);
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

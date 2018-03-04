package com.biz.Imp;

import com.biz.EK_waitBiz;
import com.dao.EK_waitDao;
import com.entity.EK_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class Ek_waitBizImp implements EK_waitBiz {

    @Autowired
    EK_waitDao ek_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<EK_wait> list = ek_waitDao.queryLists(sql,begin,end);
        int maxCount = ek_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<EK_wait> queryList() {
        return ek_waitDao.queryList();
    }

    public List<EK_wait> queryLists(String sql, int begin, int end) {
        return ek_waitDao.queryLists(sql,begin,end);
    }

    public EK_wait queryById(Serializable serializable) {
        return ek_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return ek_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            ek_waitDao.insert(object);
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
            ek_waitDao.update(object);
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
            ek_waitDao.delete(object);
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

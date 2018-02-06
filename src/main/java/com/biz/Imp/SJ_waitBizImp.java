package com.biz.Imp;

import com.biz.SJ_waitBiz;
import com.dao.SJ_waitDao;
import com.entity.SJ_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SJ_waitBizImp implements SJ_waitBiz {

    @Autowired
    SJ_waitDao sj_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SJ_wait> list = sj_waitDao.queryLists(sql,begin,end);
        int maxCount = sj_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<SJ_wait> queryList() {
        return sj_waitDao.queryList();
    }

    public List<SJ_wait> queryLists(String sql, int begin, int end) {
        return sj_waitDao.queryLists(sql,begin,end);
    }

    public SJ_wait queryById(Serializable serializable) {
        return sj_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return sj_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            sj_waitDao.insert(object);
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
            sj_waitDao.update(object);
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
            sj_waitDao.delete(object);
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

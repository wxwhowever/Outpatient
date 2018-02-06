package com.biz.Imp;

import com.biz.kQ_waitBiz;
import com.dao.KQ_waitDao;
import com.entity.KQ_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KQ_waitBizImp implements kQ_waitBiz {

    @Autowired
    KQ_waitDao kq_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<KQ_wait> list = kq_waitDao.queryLists(sql,begin,end);
        int maxCount = kq_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<KQ_wait> queryList() {
        return kq_waitDao.queryList();
    }

    public List<KQ_wait> queryLists(String sql, int begin, int end) {
        return kq_waitDao.queryLists(sql,begin,end);
    }

    public KQ_wait queryById(Serializable serializable) {
        return kq_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return kq_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            kq_waitDao.insert(object);
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
            kq_waitDao.update(object);
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
            kq_waitDao.delete(object);
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

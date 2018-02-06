package com.biz.Imp;

import com.biz.Ck_waitBiz;
import com.dao.Ck_waitDao;
import com.entity.CK_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Ck_waitBizImp implements Ck_waitBiz {

    @Autowired
    Ck_waitDao ck_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CK_wait> list = ck_waitDao.queryLists(sql,begin,end);
        int maxCount = ck_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<CK_wait> queryList() {
        return ck_waitDao.queryList();
    }

    public List<CK_wait> queryLists(String sql, int begin, int end) {
        return ck_waitDao.queryLists(sql,begin,end);
    }

    public CK_wait queryById(Serializable serializable) {
        return ck_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return ck_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            ck_waitDao.insert(object);
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
            ck_waitDao.update(object);
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
            ck_waitDao.delete(object);
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

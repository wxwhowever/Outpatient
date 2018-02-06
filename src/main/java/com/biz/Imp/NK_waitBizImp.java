package com.biz.Imp;

import com.biz.NK_waitBiz;
import com.dao.NK_waitDao;
import com.entity.NK_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NK_waitBizImp implements NK_waitBiz {

    @Autowired
    NK_waitDao nk_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<NK_wait> list = nk_waitDao.queryLists(sql,begin,end);
        int maxCount = nk_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<NK_wait> queryList() {
        return nk_waitDao.queryList();
    }

    public List<NK_wait> queryLists(String sql, int begin, int end) {
        return nk_waitDao.queryLists(sql,begin,end);
    }

    public NK_wait queryById(Serializable serializable) {
        return nk_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return nk_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            nk_waitDao.insert(object);
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
            nk_waitDao.update(object);
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
            nk_waitDao.delete(object);
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

package com.biz.Imp;

import com.biz.WK_waitBiz;
import com.dao.WK_waitDao;
import com.entity.WK_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WK_waitBizImp implements WK_waitBiz {

    @Autowired
    WK_waitDao wk_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<WK_wait> list = wk_waitDao.queryLists(sql,begin,end);
        int maxCount = wk_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<WK_wait> queryList() {
        return wk_waitDao.queryList();
    }

    public List<WK_wait> queryLists(String sql, int begin, int end) {
        return wk_waitDao.queryLists(sql,begin,end);
    }

    public WK_wait queryById(Serializable serializable) {
        return wk_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return wk_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            wk_waitDao.insert(object);
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
            wk_waitDao.update(object);
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
            wk_waitDao.delete(object);
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

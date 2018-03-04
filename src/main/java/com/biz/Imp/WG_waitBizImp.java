package com.biz.Imp;

import com.biz.WG_waitBiz;
import com.dao.WG_waitDao;
import com.entity.WG_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class WG_waitBizImp implements WG_waitBiz {

    @Autowired
    WG_waitDao wg_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<WG_wait> list = wg_waitDao.queryLists(sql,begin,end);
        int maxCount = wg_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<WG_wait> queryList() {
        return wg_waitDao.queryList();
    }

    public List<WG_wait> queryLists(String sql, int begin, int end) {
        return wg_waitDao.queryLists(sql,begin,end);
    }

    public WG_wait queryById(Serializable serializable) {
        return wg_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return wg_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            wg_waitDao.insert(object);
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
            wg_waitDao.update(object);
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
            wg_waitDao.delete(object);
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

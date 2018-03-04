package com.biz.Imp;

import com.biz.YK_waitBiz;
import com.dao.YK_waitDao;
import com.entity.YK_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class YK_waitBizImp implements YK_waitBiz {

    @Autowired
    YK_waitDao yk_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<YK_wait> list = yk_waitDao.queryLists(sql,begin,end);
        int maxCount = yk_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<YK_wait> queryList() {
        return yk_waitDao.queryList();
    }

    public List<YK_wait> queryLists(String sql, int begin, int end) {
        return yk_waitDao.queryLists(sql,begin,end);
    }

    public YK_wait queryById(Serializable serializable) {
        return yk_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return yk_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            yk_waitDao.insert(object);
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
            yk_waitDao.update(object);
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
            yk_waitDao.delete(object);
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

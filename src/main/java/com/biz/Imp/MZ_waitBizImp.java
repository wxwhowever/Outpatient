package com.biz.Imp;

import com.biz.MZ_waitBiz;
import com.dao.MZ_waitDao;
import com.entity.MZ_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MZ_waitBizImp implements MZ_waitBiz {

    @Autowired
    MZ_waitDao mz_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<MZ_wait> list = mz_waitDao.queryLists(sql,begin,end);
        int maxCount = mz_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<MZ_wait> queryList() {
        return mz_waitDao.queryList();
    }

    public List<MZ_wait> queryLists(String sql, int begin, int end) {
        return mz_waitDao.queryLists(sql,begin,end);
    }

    public MZ_wait queryById(Serializable serializable) {
        return mz_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return mz_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            mz_waitDao.insert(object);
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
            mz_waitDao.update(object);
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
            mz_waitDao.delete(object);
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

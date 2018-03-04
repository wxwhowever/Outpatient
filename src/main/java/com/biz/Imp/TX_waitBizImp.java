package com.biz.Imp;

import com.biz.TX_waitBiz;
import com.dao.TX_waitDao;
import com.entity.TX_wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TX_waitBizImp implements TX_waitBiz {

    @Autowired
    TX_waitDao tx_waitDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TX_wait> list = tx_waitDao.queryLists(sql,begin,end);
        int maxCount = tx_waitDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<TX_wait> queryList() {
        return tx_waitDao.queryList();
    }

    public List<TX_wait> queryLists(String sql, int begin, int end) {
        return tx_waitDao.queryLists(sql,begin,end);
    }

    public TX_wait queryById(Serializable serializable) {
        return tx_waitDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return tx_waitDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            tx_waitDao.insert(object);
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
            tx_waitDao.update(object);
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
            tx_waitDao.delete(object);
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

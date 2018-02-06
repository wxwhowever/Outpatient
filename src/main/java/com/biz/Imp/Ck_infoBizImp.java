package com.biz.Imp;

import com.biz.Ck_infoBiz;
import com.dao.Ck_infoDao;
import com.entity.CK_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Ck_infoBizImp implements Ck_infoBiz {

    @Autowired
    Ck_infoDao ck_infoDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CK_info> list = ck_infoDao.queryLists(sql,begin,end);
        int maxCount = ck_infoDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<CK_info> queryList() {
        return ck_infoDao.queryList();
    }

    public List<CK_info> queryLists(String sql, int begin, int end) {
        return ck_infoDao.queryLists(sql,begin,end);
    }

    public CK_info queryById(Serializable serializable) {
        return ck_infoDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return ck_infoDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            ck_infoDao.insert(object);
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
            ck_infoDao.update(object);
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
            ck_infoDao.delete(object);
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

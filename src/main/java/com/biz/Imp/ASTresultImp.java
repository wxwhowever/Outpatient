package com.biz.Imp;

import com.biz.ASTresultBiz;
import com.dao.ASTresultDao;
import com.entity.ASTresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ASTresultImp implements ASTresultBiz {

    @Autowired
    ASTresultDao aSTresultDao;


    public List<ASTresult> resultMap(String param, int begin, int end) {
        return aSTresultDao.resultMap(param, begin, end);
    }

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ASTresult> list = aSTresultDao.queryLists(sql,begin,end);
        int maxCount = aSTresultDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<ASTresult> queryList() {
        return aSTresultDao.queryList();
    }

    public List<ASTresult> queryLists(String sql, int begin, int end) {
        return aSTresultDao.queryLists(sql, begin, end);
    }

    public ASTresult queryById(Serializable serializable) {
        return aSTresultDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return aSTresultDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return aSTresultDao.insert(object);
    }

    public boolean update(Object object) {
        return aSTresultDao.update(object);
    }

    public boolean delete(Object object) {
        return aSTresultDao.delete(object);
    }

    public int getCount(String sql) {
        return aSTresultDao.getCount(sql);
    }
}

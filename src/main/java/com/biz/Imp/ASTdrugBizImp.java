package com.biz.Imp;

import com.biz.ASTdrugBiz;
import com.dao.ASTdrugDao;
import com.entity.ASTdrug;
import com.entity.CK_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ASTdrugBizImp implements ASTdrugBiz {

    @Autowired
    ASTdrugDao asTdrugDao;


    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ASTdrug> list = asTdrugDao.queryLists(sql,begin,end);
        int maxCount = asTdrugDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<ASTdrug> queryList() {
        return asTdrugDao.queryList();
    }

    public List<ASTdrug> queryLists(String sql, int begin, int end) {
        return asTdrugDao.queryLists(sql, begin, end);
    }

    public ASTdrug queryById(Serializable serializable) {
        return asTdrugDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return asTdrugDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        return asTdrugDao.insert(object);
    }

    public boolean update(Object object) {
        return asTdrugDao.update(object);
    }

    public boolean delete(Object object) {
        return asTdrugDao.delete(object);
    }

    public int getCount(String sql) {
        return asTdrugDao.getCount(sql);
    }
}

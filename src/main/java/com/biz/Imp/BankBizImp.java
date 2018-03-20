package com.biz.Imp;

import com.biz.BankBiz;
import com.biz.DrugBiz;
import com.dao.BankDao;
import com.dao.DrugDao;
import com.entity.Bank;
import com.entity.Drug;
import com.entity.DrugType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankBizImp implements BankBiz {

    @Autowired
    BankDao bankDao;

    public Map<String, Object> queryMap(String sql, int begin, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Bank> list = bankDao.queryLists(sql,begin,end);
        int maxCount = bankDao.getCount(sql);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    public List<Bank> queryList() {
        return bankDao.queryList();
    }

    public List<Bank> queryLists(String sql, int begin, int end) {
        return bankDao.queryLists(sql,begin,end);
    }

    public Bank queryById(Serializable serializable) {
        return bankDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return bankDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            bankDao.insert(object);
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
            bankDao.update(object);
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
            bankDao.delete(object);
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

    public List<DrugType> selectType() {
        return bankDao.selectType();
    }
}

package com.biz.Imp;

import com.biz.Diagnosis_ResultBiz;
import com.dao.Diagnosis_ResultDao;
import com.entity.Diagnosis_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Diagnosis_ResultBizImp implements Diagnosis_ResultBiz {

    @Autowired
    Diagnosis_ResultDao diagnosis_resultDao;

    public List<Diagnosis_result> queryResult(String sql, int begin, int end){
        return diagnosis_resultDao.queryResult(sql, begin, end);
    };


    public Map<String, Object> queryMap(String sql, int begin, int end) {
        return null;
    }

    public List<Diagnosis_result> queryList() {
        return diagnosis_resultDao.queryList();
    }

    public List<Diagnosis_result> queryLists(String sql, int begin, int end) {
        return diagnosis_resultDao.queryLists(sql,begin,end);
    }

    public Diagnosis_result queryById(Serializable serializable) {
        return diagnosis_resultDao.queryById(serializable);
    }

    public String queryMaxNo() {
        return diagnosis_resultDao.queryMaxNo();
    }

    public boolean insert(Object object) {
        boolean f = false;
        try {
            diagnosis_resultDao.insert(object);
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
            diagnosis_resultDao.update(object);
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
            diagnosis_resultDao.delete(object);
            f = true;
        }catch (Exception e){
            f =false;
            e.printStackTrace();
        }
        return f;
    }

    public int getCount(String sql) {
        return diagnosis_resultDao.getCount(sql);
    }

    public int prescribeCount() {
        return diagnosis_resultDao.prescribeCount();
    }

    public int ASTdrugCount() {
        return diagnosis_resultDao.ASTdrugCount();
    }

    public int ASTresultCount() {
        return diagnosis_resultDao.ASTresultCount();
    }

    public int injectDrugCount() {
        return diagnosis_resultDao.injectDrugCount();
    }

    public int transfusionCount() {
        return diagnosis_resultDao.transfusionCount();
    }

    public int treatCount() {
        return diagnosis_resultDao.treatCount();
    }
}

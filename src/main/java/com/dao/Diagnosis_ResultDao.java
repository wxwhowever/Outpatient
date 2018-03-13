package com.dao;

import com.base.BaseDao;
import com.entity.Diagnosis_result;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Diagnosis_ResultDao extends BaseDao<Diagnosis_result> {



    /**
     * 查询所有的集合 + 分页
     * @param sql
     * @param begin
     * @param end
     * @return
     */
    List<Diagnosis_result> queryResult(String sql, int begin, int end);


    /**
     * 查询所有不带参
     * @return
     */
    List<Diagnosis_result> queryList();

    /**
     * 查询所有带参
     * @return
     */
    public List<Diagnosis_result> queryLists(String sql, int begin, int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    Diagnosis_result queryById(Serializable serializable);

    /**
     * 查询最大的编号
     * @return
     */
    public String queryMaxNo();

    /**
     * 增加
     * @param object
     * @return
     */
    boolean insert(Object object);

    /**
     * 修改
     * @param object
     * @return
     */
    boolean update(Object object);

    /**
     * 删除
     * @param object
     * @return
     */
    boolean delete(Object object);

    /**
     * 查询表最大行数
     * @param sql
     * @return
     */
    int getCount(String sql);

    int prescribeCount();

    int ASTdrugCount();

    int ASTresultCount();

    int injectDrugCount();

    int transfusionCount();

    int treatCount();

}

package com.dao;

import com.base.BaseDao;
import com.entity.Medicalcard;
import com.entity.Patient;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PatientDao extends BaseDao<Patient> {

    /**
     * 查询所有的集合 + 分页
     * @param sql
     * @param begin
     * @param end
     * @return
     */
    Map<String, Object> queryMap(String sql, int begin, int end);

    /**
     * 查询所有不带参
     * @return
     */
    List<Patient> queryList();

    /**
     * 查询所有带参
     * @return
     */
    public List<Patient> queryLists(String sql, int begin, int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    Patient queryById(Serializable serializable);

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

    Patient queryByRsno(Serializable serializable);
}

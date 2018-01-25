package com.dao;

import com.base.BaseDao;
import com.entity.Doctorcard;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DoctorcardDao extends BaseDao<Doctorcard>{
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
    List<Doctorcard> queryList();

    /**
     * 查询所有带参
     * @return
     */
    public List<Doctorcard> queryLists (String sql,int begin,int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    Doctorcard QueryById(Serializable serializable);

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
}

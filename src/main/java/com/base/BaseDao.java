package com.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    /**
     * 查询所有 + 分页
     * @param sql
     * @param begin
     * @param end
     * @return
     */
    public Map<String,Object> queryMap (String sql, int begin, int end);

    /**
     * 查询所有不带参
     * @return
     */
    public List<T> queryList ();

    /**
     * 查询所有带参
     * @return
     */
    public List<T> queryLists (String sql,int begin,int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    public T QueryById(Serializable serializable);

    /**
     * 增加
     * @param object
     * @return
     */
    public boolean insert(Object object);

    /**
     * 修改
     * @param object
     * @return
     */
    public boolean update(Object object);

    /**
     * 删除
     * @param object
     * @return
     */
    public boolean delete(Object object);

    /**
     * 查询表总行数
     * @param sql
     * @return
     */
    public int getCount(String sql);
}

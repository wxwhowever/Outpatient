package com.biz;

import com.base.BaseBiz;
import com.entity.Medicalcard;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MedicalcardBiz extends BaseBiz<Medicalcard>{

    /**
     * 查询所有 + 分页
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
    List<Medicalcard> queryList();

    /**
     * 查询所有带参
     * @return
     */
    List<Medicalcard> queryLists(String sql, int begin, int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    Medicalcard queryById(Serializable serializable);

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
     * 查询表的总行数
     * @param sql
     * @return
     */
    int getCount(String sql);
}

package com.biz;

import com.base.BaseBiz;
import com.entity.Bank;
import com.entity.DrugType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BankBiz extends BaseBiz<Bank> {
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
    List<Bank> queryList();

    /**
     * 查询所有带参
     * @return
     */
    List<Bank> queryLists(String sql, int begin, int end);

    /**
     * 查询单个
     * @param serializable
     * @return
     */
    Bank queryById(Serializable serializable);

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
     * 查询表的总行数
     * @param sql
     * @return
     */
    int getCount(String sql);

    List<DrugType> selectType();
}

package com.biz;

import com.base.BaseBiz;
import com.entity.Prescribe;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PrescribeBiz extends BaseBiz<Prescribe>{

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<Prescribe> queryList();

    List<Prescribe> queryLists(String sql, int begin, int end);

    Prescribe queryById(Serializable serializable);

    public String queryMaxNo();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);
}

package com.biz;

import com.base.BaseBiz;
import com.entity.Treat;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface TreatBiz extends BaseBiz<Treat> {

    List<Treat> resultMap(String param, int begin, int end);

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<Treat> queryList();

    List<Treat> queryLists(String sql, int begin, int end);

    Treat queryById(Serializable serializable);

    String queryMaxNo();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);
}

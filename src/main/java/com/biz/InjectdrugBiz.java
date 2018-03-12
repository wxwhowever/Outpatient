package com.biz;

import com.base.BaseBiz;
import com.entity.Injectdrug;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface InjectdrugBiz extends BaseBiz<Injectdrug> {

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<Injectdrug> queryList();

    List<Injectdrug> queryLists(String sql, int begin, int end);

    Injectdrug queryById(Serializable serializable);

    String queryMaxNo();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);
}

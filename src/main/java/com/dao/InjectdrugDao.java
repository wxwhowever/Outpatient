package com.dao;

import com.base.BaseDao;
import com.entity.Injectdrug;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface InjectdrugDao extends BaseDao<Injectdrug> {

    List<Injectdrug> resultMap(String param,int begin,int end);

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<Injectdrug> queryList();

    List<Injectdrug> queryLists(String sql, int begin, int end);

    Injectdrug queryById(Serializable serializable);

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(@Param("param1") String sql);

    String queryMaxNo();
}

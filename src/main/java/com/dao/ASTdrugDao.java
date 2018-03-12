package com.dao;

import com.base.BaseDao;
import com.entity.ASTdrug;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ASTdrugDao extends BaseDao<ASTdrug> {


    Map<String, Object> queryMap(String sql, int begin, int end);

    List<ASTdrug> queryList();

    List<ASTdrug> queryLists(String sql, int begin, int end);

    ASTdrug queryById(Serializable serializable);

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);

    int queryMaxNo();
}

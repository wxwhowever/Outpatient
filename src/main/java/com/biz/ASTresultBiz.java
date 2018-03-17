package com.biz;

import com.base.BaseBiz;
import com.entity.ASTresult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ASTresultBiz extends BaseBiz<ASTresult> {

    List<ASTresult> resultMap(String param, int begin, int end);

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<ASTresult> queryList();

    List<ASTresult> queryLists(String sql, int begin, int end);

    ASTresult queryById(Serializable serializable);

    String queryMaxNo();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);
}

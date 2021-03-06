package com.biz;

import com.base.BaseBiz;
import com.entity.ASTdrug;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ASTdrugBiz extends BaseBiz<ASTdrug> {

    List<ASTdrug> resultMap(String param,int begin,int end);

    Map<String, Object> queryMap(String sql, int begin, int end);

    List<ASTdrug> queryList();

    List<ASTdrug> queryLists(String sql, int begin, int end);

    ASTdrug queryById(Serializable serializable);

    Map<String,Object> getByid(Serializable serializable);

    String queryMaxNo();

    boolean insert(Object object);

    boolean update(Object object);

    boolean delete(Object object);

    int getCount(String sql);
}

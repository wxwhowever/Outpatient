package com.controller;

import com.biz.ASTresultBiz;
import com.entity.ASTresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ASTresultController {
    @Autowired
    ASTresultBiz asTresultBiz;

    @ResponseBody
    @RequestMapping("astresult_resultmap")
    public Map<String,Object> resultmap(HttpServletRequest request){
        String search = request.getParameter("search");
        String page = request.getParameter("page");
        String count = request.getParameter("count");
        String param = "";
        int begin = 0;
        int end = 5;
        if(page != null && page != ""){
            begin = (Integer.parseInt(page)-1)*end;
        }
        if(search != null && search != ""){
            param = search;
        }
        if(count != null && count!= ""){
            end = Integer.parseInt(count);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        List<ASTresult> list = asTresultBiz.resultMap(param,begin, end);
        int maxCount = asTresultBiz.getCount(param);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

}

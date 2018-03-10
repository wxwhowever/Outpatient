package com.controller;

import com.biz.PrescribeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class PrescribeController {

    @Autowired
    PrescribeBiz prescribeBiz;

    @ResponseBody
    @RequestMapping("queryMap-prescribe")
    public Map<String,Object> queryMap(HttpServletRequest request){
        String search = request.getParameter("search");
        String page = request.getParameter("page");
        String count = request.getParameter("count");
        String sql = "";
        int begin = 0;
        int end = 5;
        if(page != null && page != ""){
            begin = (Integer.parseInt(page)-1)*end;
        }
        if(search != null && search != ""){
            sql = search;
        }
        if(count != null && count!= ""){
            end = Integer.parseInt(count);
        }
        Map<String,Object> map = prescribeBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("resultmap")
    public List<Map<String, Object>> test(){
        List<Map<String, Object>> list = prescribeBiz.resultMap();
        return list;
    }



}

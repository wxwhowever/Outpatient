package com.controller;

import com.biz.ZY_waitBiz;
import com.entity.ZY_wait;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class ZY_waitController {

    @Autowired
    ZY_waitBiz zy_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-zy_wait")
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
        Map<String,Object> map = zy_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-zy_wait")
    public ZY_wait queryById(HttpServletRequest request){
        ZY_wait zy_wait = zy_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return zy_wait;
    }

    @ResponseBody
    @RequestMapping("insertZy_wait")
    public String insert(HttpServletRequest request) throws IOException {
        ZY_wait zy_wait = new ObjectMapper().readValue(request.getParameter("zy_wait"), ZY_wait.class);

        String result = "";
        boolean insert = zy_waitBiz.insert(zy_wait);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateZy_wait")
    public String update(HttpServletRequest request) throws IOException {
        ZY_wait zy_wait = new ObjectMapper().readValue(request.getParameter("zy_wait"), ZY_wait.class);
        String result = "";
        boolean update = zy_waitBiz.update(zy_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteZy_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = zy_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
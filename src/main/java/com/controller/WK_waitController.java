package com.controller;

import com.biz.WK_waitBiz;
import com.entity.WK_wait;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class WK_waitController {

    @Autowired
    WK_waitBiz wk_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-wk_wait")
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
        Map<String,Object> map = wk_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-wk_wait")
    public WK_wait queryById(HttpServletRequest request){
        WK_wait wk_wait = wk_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return wk_wait;
    }

    @ResponseBody
    @RequestMapping("insertWk_wait")
    public String insert(HttpServletRequest request) throws IOException {
        WK_wait wk_wait = new ObjectMapper().readValue(request.getParameter("wk_wait"), WK_wait.class);

        String result = "";
        boolean insert = wk_waitBiz.insert(wk_wait);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateWk_wait")
    public String update(HttpServletRequest request) throws IOException {
        WK_wait wk_wait = new ObjectMapper().readValue(request.getParameter("wk_wait"), WK_wait.class);
        String result = "";
        boolean update = wk_waitBiz.update(wk_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteWk_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = wk_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
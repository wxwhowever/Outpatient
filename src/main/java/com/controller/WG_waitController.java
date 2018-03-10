package com.controller;

import com.biz.WG_waitBiz;
import com.biz.WK_waitBiz;
import com.entity.WG_wait;
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
public class WG_waitController {

    @Autowired
    WG_waitBiz wg_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-wg_wait")
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
        Map<String,Object> map = wg_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-wg_wait")
    public WG_wait queryById(HttpServletRequest request){
        WG_wait wg_wait = wg_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return wg_wait;
    }

    @ResponseBody
    @RequestMapping("insertWg_wait")
    public String insert(HttpServletRequest request,WG_wait wg_wait) throws IOException {
        boolean insert = wg_waitBiz.insert(wg_wait);
        String result = "";
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateWg_wait")
    public String update(HttpServletRequest request) throws IOException {
        WG_wait wg_wait = new ObjectMapper().readValue(request.getParameter("wg_wait"), WG_wait.class);
        String result = "";
        boolean update = wg_waitBiz.update(wg_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteWg_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = wg_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
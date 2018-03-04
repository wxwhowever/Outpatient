package com.controller;

import com.biz.EK_waitBiz;
import com.entity.EK_wait;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class EK_waitController {

    @Autowired
    EK_waitBiz ek_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-ek_wait")
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
        Map<String,Object> map = ek_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-ek_wait")
    public EK_wait queryById(HttpServletRequest request){
        EK_wait ek_wait = ek_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return ek_wait;
    }

    @ResponseBody
    @RequestMapping("insertEk_wait")
    public String insert(HttpServletRequest request) throws IOException {
        EK_wait ek_wait = new ObjectMapper().readValue(request.getParameter("ek_wait"), EK_wait.class);

        String result = "";
        boolean insert = ek_waitBiz.insert(ek_wait);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateEk_wait")
    public String update(HttpServletRequest request) throws IOException {
        EK_wait ek_wait = new ObjectMapper().readValue(request.getParameter("ek_wait"), EK_wait.class);
        String result = "";
        boolean update = ek_waitBiz.update(ek_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteEk_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = ek_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
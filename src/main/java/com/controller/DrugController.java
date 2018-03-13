package com.controller;

import com.biz.DrugBiz;
import com.entity.Drug;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class DrugController {

    @Autowired
    DrugBiz drugBiz;

    @ResponseBody
    @RequestMapping("queryMap-drug")
    public  Map<String,Object> queryMap(HttpServletRequest request){
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
       Map<String,Object> map = drugBiz.queryMap(sql,begin, end);

       return map;
    }

    @ResponseBody
    @RequestMapping("queryById-drug")
    public Drug queryById(HttpServletRequest request){
        Drug drug = drugBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return drug;
    }

    @ResponseBody
    @RequestMapping("insertDrug")
    public String insert(HttpServletRequest request) throws IOException {
        Drug drug = new ObjectMapper().readValue(request.getParameter("drug"), Drug.class);

        String result = "";
        boolean insert = drugBiz.insert(drug);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateDrug")
    public String update(HttpServletRequest request) throws IOException {
        Drug drug = new ObjectMapper().readValue(request.getParameter("drug"), Drug.class);
        String result = "";
        boolean update = drugBiz.update(drug);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deletedrug")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = drugBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
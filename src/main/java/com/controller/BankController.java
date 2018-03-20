package com.controller;

import com.biz.BankBiz;
import com.entity.Bank;
import com.entity.DrugType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class BankController {

    @Autowired
    BankBiz bankBiz;

    @ResponseBody
    @RequestMapping("queryMap-bank")
    public  Map<String,Object> queryMap(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");

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
       Map<String,Object> map = bankBiz.queryMap(sql,begin, end);

       return map;
    }

    @ResponseBody
    @RequestMapping("queryById-bank")
    public Bank queryById(HttpServletRequest request){
        Bank bank = bankBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return bank;
    }

    //查询类型
    @ResponseBody
    @RequestMapping("queryType")
    public List<DrugType> queryType(HttpServletRequest request){
        List<DrugType> drugType = bankBiz.selectType();
        return drugType;
    }

    @ResponseBody
    @RequestMapping("insertbank")
    public String insert(HttpServletRequest request) throws IOException {
        Bank bank = new ObjectMapper().readValue(request.getParameter("bank"),Bank.class);
        String drugtype=request.getParameter("type");
        bank.setDrug_type(Integer.parseInt(drugtype));
        String result = "";
        boolean insert = bankBiz.insert(bank);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updatebank")
    public String update(HttpServletRequest request) throws IOException {
        Bank bank = new ObjectMapper().readValue(request.getParameter("bank"), Bank.class);
        String drugtype=request.getParameter("type");
        bank.setDrug_type(Integer.parseInt(drugtype));
        String result = "";
        boolean update = bankBiz.update(bank);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deletebank")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = bankBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
package com.controller;

import com.biz.DoctorcardBiz;
import com.entity.Doctorcard;
import com.entity.Medicalcard;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class DoctorcardController {

    @Autowired
    DoctorcardBiz doctorcardBiz;


    @ResponseBody
    @RequestMapping("queryMap-doctorcard")
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
        Map<String,Object> map = doctorcardBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-doctorcard")
    public Doctorcard queryById(HttpServletRequest request){
        Doctorcard doctorcard = doctorcardBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return doctorcard;
    }

    @ResponseBody
    @RequestMapping("insertDoctorcard")
    public String insert(HttpServletRequest request) throws IOException {
        System.out.println(request.getParameter("doctorcard"));
        Doctorcard doctorcard = new ObjectMapper().readValue(request.getParameter("doctorcard"), Doctorcard.class);
//        查询出最大编号
        String yyno = doctorcardBiz.queryMaxNo();
//        将最大编号加一,加到数据库
        int newYyno = Integer.parseInt(yyno)+1;
        System.out.println(newYyno);
        doctorcard.setYyno("YY0"+newYyno);
        doctorcard.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = doctorcardBiz.insert(doctorcard);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateDoctorcard")
    public String update(HttpServletRequest request) throws IOException {
        Doctorcard doctorcard = new ObjectMapper().readValue(request.getParameter("doctorcard"), Doctorcard.class);
        String result = "";
        boolean update = doctorcardBiz.update(doctorcard);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteDoctorcard")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = doctorcardBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
package com.controller;

import com.biz.*;
import com.entity.*;
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
public class RegistrationController {

    @Autowired
    RegistrationBiz registrationBiz;

    @ResponseBody
    @RequestMapping("queryMap-registration")
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
        Map<String,Object> map = registrationBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-registration")
    public Registration queryById(HttpServletRequest request){
        Registration registration = registrationBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return registration;
    }

    @ResponseBody
    @RequestMapping("insertRegistration")
    public String insert(HttpServletRequest request) throws IOException {
        Registration registration = new ObjectMapper().readValue(request.getParameter("registration"), Registration.class);
//        查询最大的挂号编号
        String rsno = registrationBiz.queryMaxNo();

//      将最大的编号加一，添加到数据库
        int newRsno = Integer.parseInt(rsno)+1;
        registration.setRsno("RS"+newRsno);
        registration.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = registrationBiz.insert(registration);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateRegistration")
    public String update(HttpServletRequest request) throws IOException {
        Registration registration = new ObjectMapper().readValue(request.getParameter("registration"), Registration.class);
        String result = "";
        boolean update = registrationBiz.update(registration);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteRegistration")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = registrationBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }


}
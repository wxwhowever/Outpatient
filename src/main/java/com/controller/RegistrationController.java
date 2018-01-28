package com.controller;

import com.biz.MedicalcardBiz;
import com.biz.RegistrationBiz;
import com.entity.Medicalcard;
import com.entity.Registration;
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
        int end = 10;
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
//        String jzno = registrationBiz.queryMaxNo();
//        String newJzno = jzno.substring((jzno.length()-1)+1);
//        System.out.println(jzno+newJzno);
//        System.out.println(new Date().toLocaleString());
//
//        registration.setJZNO(jzno+newJzno);
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
        Registration registration = registrationBiz.queryById(request.getParameter("id"));
        String result = "";
        boolean delete = registrationBiz.delete(registration);
        if(delete) {
            result = "success";
        }
        return result;
    }

}
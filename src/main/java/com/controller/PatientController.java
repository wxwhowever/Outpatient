package com.controller;

import com.biz.*;
import com.entity.CK_wait;
import com.entity.Patient;
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
public class PatientController {

    @Autowired
    PatientBiz patientBiz;


    @ResponseBody
    @RequestMapping("queryMap-patient")
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
        Map<String,Object> map = patientBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-patient")
    public Patient queryById(HttpServletRequest request){
        Patient patient = patientBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return patient;
    }

    @ResponseBody
    @RequestMapping("insertPatient")
    public String insert(HttpServletRequest request) throws IOException {
        Patient patient = new ObjectMapper().readValue(request.getParameter("patient"), Patient.class);
//        查询最大的编号
        String pno = patientBiz.queryMaxNo();
//        将最大的编号的加一，添加到数据库
        int newPno = Integer.parseInt(pno)+1;

        patient.setPno("P2018"+newPno);
        patient.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = patientBiz.insert(patient);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updatePatient")
    public String update(HttpServletRequest request) throws IOException {
        Patient patient = new ObjectMapper().readValue(request.getParameter("patient"), Patient.class);
        String result = "";
        boolean update = patientBiz.update(patient);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deletePatient")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = patientBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
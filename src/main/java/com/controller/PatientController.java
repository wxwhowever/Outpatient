package com.controller;

import com.biz.MedicalcardBiz;
import com.biz.PatientBiz;
import com.entity.Medicalcard;
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
//        String jzno = patientBiz.queryMaxNo();
//        String newJzno = jzno.substring((jzno.length()-1)+1);
//        System.out.println(jzno+newJzno);
//        System.out.println(new Date().toLocaleString());
//
//        medicalcard.setJZNO(jzno+newJzno);
//        medicalcard.setCreatedate(new Date().toLocaleString());
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
        Patient patient = patientBiz.queryById(request.getParameter("id"));
        String result = "";
        boolean delete = patientBiz.delete(patient);
        if(delete) {
            result = "success";
        }
        return result;
    }

}
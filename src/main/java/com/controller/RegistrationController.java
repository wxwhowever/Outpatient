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
    @Autowired
    TriageBiz triageBiz;
    @Autowired
    PatientBiz patientBiz;

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

//        挂号增加的同时 增加到分诊台
        Triage triage = new Triage();
        int tno = Integer.parseInt(triageBiz.queryMaxNo())+1;
        triage.setTno("TNO2018"+tno);
        triage.setState(0);
        triage.setAge(registration.getAge());
        triage.setName(registration.getName());
        triage.setPhone(registration.getPhone());
        triage.setSex(registration.getSex());
        triage.setType(registration.getType());
        triage.setJzno(registration.getJzno());
        triage.setRsno(registration.getRsno());
        triage.setYyno(registration.getYyno());
        triage.setYbno(registration.getYbno());
        triage.setCreatedate(new Date().toLocaleString());
        System.out.println(triage);
        triageBiz.insert(triage);

//        挂号增加的同时，增加到病人表
        Patient patient = new Patient();
        String pno = patientBiz.queryMaxNo();
        int newPno = Integer.parseInt(pno)+1;
        patient.setPno("P2018"+newPno);
        patient.setAddress(registration.getAddress());
        patient.setAge(registration.getAge());
        patient.setCard(registration.getCard());
        patient.setSex(registration.getSex());
        patient.setName(registration.getName());
        patient.setRemark("");//备注
        patient.setProfession(registration.getProfession());
        patient.setPhone(registration.getPhone());
        patient.setType(registration.getType());
        patient.setJzno(registration.getJzno());
        patient.setRsno(registration.getRsno());
        patient.setYyno(registration.getYyno());
        patient.setYbno(registration.getYbno());
        patient.setCreatedate(new Date().toLocaleString());
        System.out.println(patient);
        patientBiz.insert(patient);

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
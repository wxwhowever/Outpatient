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
public class Ck_waitController {

    @Autowired
    Ck_waitBiz ck_waitBiz;
    @Autowired
    Ck_infoBiz ck_infoBiz;
    @Autowired
    MedicalcardBiz medicalcardBiz;
    @Autowired
    DoctorBiz doctorBiz;
    @Autowired
    PatientBiz patientBiz;



    @ResponseBody
    @RequestMapping("queryMap-ck_wait")
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
        Map<String,Object> map = ck_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-ck_wait")
    public CK_wait queryById(HttpServletRequest request){
        CK_wait ck_wait = ck_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return ck_wait;
    }

    @ResponseBody
    @RequestMapping("insertCk_wait")
    public String insert(HttpServletRequest request) throws IOException {
//        记录产科病人信息
        CK_info ck_info = new ObjectMapper().readValue(request.getParameter("ck_info"), CK_info.class);
        ck_infoBiz.insert(ck_info);
//        查询病人信息
        Patient patient = patientBiz.queryById(ck_info.getPatientList().get(1).getPno());
//        查询病人就诊卡
        Medicalcard medicalcard = medicalcardBiz.queryById(ck_info.getMedicalcard().getJzno());
//        查询病人分诊医生
        Doctor doctor = doctorBiz.queryById(ck_info.getDoctor().getDno());

        CK_wait ck_wait = new CK_wait();
        //增加产科候诊病人编号
        String ckwno = ck_waitBiz.queryMaxNo();
        int newCkno = Integer.parseInt(ckwno)+1;
        ck_wait.setWno("CKWNO"+newCkno);
        ck_wait.setPatientList(ck_info.getPatientList());
        ck_wait.setName(ck_info.getName());
        ck_wait.setSex(patient.getSex());
        ck_wait.setAge(patient.getAge());
        ck_wait.setType(patient.getType());
        ck_wait.setRemark(patient.getRemark());
        ck_wait.setLevel("3");
        ck_wait.setDate(new Date().toLocaleString());
        ck_wait.setMedicalcard(medicalcard);
        ck_wait.setDoctor(doctor);

        String result = "";
        boolean insert = ck_waitBiz.insert(ck_wait);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateCk_wait")
    public String update(HttpServletRequest request) throws IOException {
        CK_wait ck_wait = new ObjectMapper().readValue(request.getParameter("ck_wait"), CK_wait.class);
        String result = "";
        boolean update = ck_waitBiz.update(ck_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteCk_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = ck_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
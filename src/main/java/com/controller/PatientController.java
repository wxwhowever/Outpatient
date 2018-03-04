package com.controller;

import com.biz.*;
import com.entity.CK_wait;
import com.entity.Medicalcard;
import com.entity.Patient;
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
public class PatientController {

    @Autowired
    PatientBiz patientBiz;
    @Autowired
    Ck_waitBiz ck_waitBiz;
    @Autowired
    com.biz.kQ_waitBiz kQ_waitBiz;
    @Autowired
    MZ_waitBiz mz_waitBiz;
    @Autowired
    NK_waitBiz nk_waitBiz;
    @Autowired
    SJ_waitBiz sj_waitBiz;
    @Autowired
    TX_waitBiz tx_waitBiz;
    @Autowired
    WK_waitBiz wk_waitBiz;
    @Autowired
    WG_waitBiz wg_waitBiz;
    @Autowired
    YK_waitBiz yk_waitBiz;
    @Autowired
    ZY_waitBiz zy_waitBiz;
    @Autowired
    EK_waitBiz ek_waitBiz;

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
        int newJzno = Integer.parseInt(pno)+1;

        patient.setPno("P2018"+newJzno);
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

    @ResponseBody
    @RequestMapping("triageInsert")
    public String triageInsert(HttpServletRequest request) throws IOException {
//        分配病人的挂号编号
        String id = request.getParameter("id");
//        分配的科
        String triage = request.getParameter("triage");
//        根据分配的科添加
        if(triage=="1"){
            CK_wait ck_wait = new CK_wait();
            String wno = ck_waitBiz.queryMaxNo();
            ck_wait.setWno("WKWNO"+(wno+1));
            ck_waitBiz.insert(ck_wait);
        }
        else if(triage=="2"){

        }
        else if(triage=="3"){

        }
        else if(triage=="4"){

        }
        else if(triage=="5"){

        }
        else if(triage=="6"){

        }
        else if(triage=="7"){

        }
        else if(triage=="8"){

        }
        else if(triage=="9"){

        }
        else if(triage=="10"){

        }
        else if(triage=="11"){

        }

        return null;
    }


}
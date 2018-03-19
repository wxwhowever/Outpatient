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
    @RequestMapping("updateCk_wait")
    public String update(HttpServletRequest request) throws IOException {
//      候诊ID
        int waitId = Integer.parseInt(request.getParameter("waitId"));
//      选择调整的等级
        String level = request.getParameter("level");
        String result = "";
//        根据得到 id 调整队列,设置优先级
        CK_wait ck_wait = ck_waitBiz.queryById(waitId);
        ck_wait.setLevel(level);
        boolean update = ck_waitBiz.update(ck_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteCk_wait")
    public String delete(HttpServletRequest request) throws IOException {
//        得到id
        String id = request.getParameter("id");
        String result = "";
        boolean delete = ck_waitBiz.delete(Integer.parseInt(id));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
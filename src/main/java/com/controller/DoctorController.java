package com.controller;

import com.biz.DoctorBiz;
import com.entity.Doctor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class DoctorController {

    @Autowired
    DoctorBiz doctorBiz;


    @ResponseBody
    @RequestMapping("queryMap-doctor")
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
        Map<String,Object> map = doctorBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-doctor")
    public Doctor queryById(HttpServletRequest request){
        Doctor doctor = doctorBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return doctor;
    }

    @ResponseBody
    @RequestMapping("insertDoctor")
    public String insert(HttpServletRequest request) throws IOException {
        Doctor doctor = new ObjectMapper().readValue(request.getParameter("doctor"), Doctor.class);
//        查询出最大编号
        String dno = doctorBiz.queryMaxNo();
//        将最大编号加一,加到数据库
        int newDno = Integer.parseInt(dno)+1;
        doctor.setDno("d2018"+newDno);
        String result = "";
        boolean insert = doctorBiz.insert(doctor);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateDoctor")
    public String update(HttpServletRequest request) throws IOException {
        Doctor doctor = new ObjectMapper().readValue(request.getParameter("doctor"), Doctor.class);
        String result = "";
        boolean update = doctorBiz.update(doctor);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteDoctor")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = doctorBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
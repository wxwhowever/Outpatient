package com.controller;

import com.biz.MedicalBiz;
import com.entity.Medical;
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
public class MedicalController {

    @Autowired
    MedicalBiz medicalBiz;


    @ResponseBody
    @RequestMapping("queryMap-medical")
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
        Map<String,Object> map = medicalBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-medical")
    public Medical queryById(HttpServletRequest request){
        Medical medical = medicalBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return medical;
    }

    @ResponseBody
    @RequestMapping("insertMedical")
    public String insert(HttpServletRequest request) throws IOException {
        Medical medical = new ObjectMapper().readValue(request.getParameter("medical"), Medical.class);

//        查询最大的病案号
        String mcno = medicalBiz.queryMaxNo();
//        将最大的病案号加一，添加到数据库
        int newMcno = Integer.parseInt(mcno) + 1;
        medical.setMcno("MC2018"+newMcno);
        medical.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = medicalBiz.insert(medical);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateMedical")
    public String update(HttpServletRequest request) throws IOException {
        Medical medical = new ObjectMapper().readValue(request.getParameter("medical"), Medical.class);
        String result = "";
        boolean update = medicalBiz.update(medical);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteMedical")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = medicalBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
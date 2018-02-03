package com.controller;

import com.biz.MedicalcardBiz;
import com.entity.Medicalcard;
import com.entity.Medicarecard;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.stream.events.EndDocumentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MedicalcardController {

    @Autowired
    MedicalcardBiz medicalcardBiz;


    @ResponseBody
    @RequestMapping("queryMap-medicalcard")
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
        Map<String,Object> map = medicalcardBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-medicalcard")
    public Medicalcard queryById(HttpServletRequest request){
        Medicalcard medicalcard = medicalcardBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return medicalcard;
    }

    @ResponseBody
    @RequestMapping("insertMedicalcard")
    public String insert(HttpServletRequest request) throws IOException {
        Medicalcard medicalcard = new ObjectMapper().readValue(request.getParameter("medicalcard"), Medicalcard.class);
//        查询出最大编号
        String jzno = medicalcardBiz.queryMaxNo();
//        将最大编号加一,加到数据库
        int newJzno = Integer.parseInt(jzno)+1;
        medicalcard.setJzno("GZ"+newJzno);
        medicalcard.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = medicalcardBiz.insert(medicalcard);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateMedicalcard")
    public String update(HttpServletRequest request) throws IOException {
        Medicalcard medicalcard = new ObjectMapper().readValue(request.getParameter("medicalcard"), Medicalcard.class);
        String result = "";
        boolean update = medicalcardBiz.update(medicalcard);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteMedicalcard")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = medicalcardBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
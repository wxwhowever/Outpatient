package com.controller;

import com.biz.MedicalcardBiz;
import com.biz.MedicarecardBiz;
import com.entity.Medicalcard;
import com.entity.Medicarecard;
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
public class MedicarecardController {

    @Autowired
    MedicarecardBiz medicarecardBiz;


    @ResponseBody
    @RequestMapping("queryMap-medicarecard")
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
        Map<String,Object> map = medicarecardBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-medicarecard")
    public Medicarecard queryById(HttpServletRequest request){
        Medicarecard medicarecard = medicarecardBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return medicarecard;
    }

    @ResponseBody
    @RequestMapping("insertMedicarecard")
    public String insert(HttpServletRequest request) throws IOException {
        Medicarecard medicarecard = new ObjectMapper().readValue(request.getParameter("medicarecard"), Medicarecard.class);
        String ybno = medicarecardBiz.queryMaxNo();
        String newYbno = ybno.substring((ybno.length()-1)+1);
        System.out.println(ybno+newYbno);
        System.out.println(new Date().toLocaleString());

        medicarecard.setYbno(ybno+newYbno);
        medicarecard.setCreatedate(new Date().toLocaleString());
        String result = "";
        boolean insert = medicarecardBiz.insert(medicarecard);
        if(insert) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateMedicarecard")
    public String update(HttpServletRequest request) throws IOException {
        Medicarecard medicarecard = new ObjectMapper().readValue(request.getParameter("medicarecard"), Medicarecard.class);
        String result = "";
        boolean update = medicarecardBiz.update(medicarecard);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteMedicarecard")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = medicarecardBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
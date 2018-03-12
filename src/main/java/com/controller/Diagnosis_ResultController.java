package com.controller;

import com.biz.Ck_infoBiz;
import com.biz.Diagnosis_ResultBiz;
import com.entity.CK_info;
import com.entity.Diagnosis_result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class Diagnosis_ResultController {

    @Autowired
    Diagnosis_ResultBiz diagnosis_resultBiz;


    @ResponseBody
    @RequestMapping("queryMap-diagnosis_result")
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
        Map<String,Object> map = diagnosis_resultBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-diagnosis_result")
    public Diagnosis_result queryById(HttpServletRequest request){
        Diagnosis_result diagnosis_result = diagnosis_resultBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return diagnosis_result;
    }

    @ResponseBody
    @RequestMapping("updateDiagnosis_result")
    public String update(HttpServletRequest request) throws IOException {
        Diagnosis_result diagnosis_result = new ObjectMapper().readValue(request.getParameter("ck_info"), Diagnosis_result.class);
        String result = "";
        boolean update = diagnosis_resultBiz.update(diagnosis_result);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteDiagnosis_result")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = diagnosis_resultBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
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


    //开药单数量
    @ResponseBody
    @RequestMapping("prescribeCount")
    public int prescribeCount(){
        int prescribeCount = diagnosis_resultBiz.prescribeCount();
        return prescribeCount;
    }

    //皮试用药单数量
    @ResponseBody
    @RequestMapping("prescribeCount")
    public int ASTdrugCount(){
        int ASTdrugCount = diagnosis_resultBiz.ASTdrugCount();
        return ASTdrugCount;
    }

    //注射用药单
    @ResponseBody
    @RequestMapping("injectDrugCount")
    public int injectDrugCount(){
        int injectDrugCount = diagnosis_resultBiz.injectDrugCount();
        return injectDrugCount;
    }

    //输液用药单
    @ResponseBody
    @RequestMapping("transfusionCount")
    public int transfusionCount(){
        int transfusionCount = diagnosis_resultBiz.transfusionCount();
        return transfusionCount;
    }

}
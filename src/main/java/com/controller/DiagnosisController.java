package com.controller;

import com.biz.Diagnosis_ResultBiz;
import com.entity.Diagnosis_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DiagnosisController {

    @Autowired
    Diagnosis_ResultBiz diagnosis_resultBiz;

    @ResponseBody
    @RequestMapping("diagnosisResult")
    public Map<String,Object> resultmap(HttpServletRequest request){
        String search = request.getParameter("search");
        String page = request.getParameter("page");
        String count = request.getParameter("count");
        String param = "";
        int begin = 0;
        int end = 5;
        if(page != null && page != ""){
            begin = (Integer.parseInt(page)-1)*end;
        }
        if(search != null && search != ""){
            param = search;
        }
        if(count != null && count!= ""){
            end = Integer.parseInt(count);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        List<Diagnosis_result> list = diagnosis_resultBiz.queryResult(param,begin,end);
        int maxCount = diagnosis_resultBiz.getCount(param);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        int prescribeCount = diagnosis_resultBiz.prescribeCount();
        int ASTdrugCount = diagnosis_resultBiz.ASTdrugCount();
        int ASTresultCount = diagnosis_resultBiz.ASTresultCount();
        int injectDrugCount = diagnosis_resultBiz.injectDrugCount();
        int transfusionCount = diagnosis_resultBiz.transfusionCount();
        int treatCount = diagnosis_resultBiz.treatCount();
        map.put("listData",list);
        map.put("maxPage",maxPage);
        map.put("prescribeCount",prescribeCount);
        map.put("ASTdrugCount",ASTdrugCount);
        map.put("ASTresultCount",ASTresultCount);
        map.put("injectDrugCount",injectDrugCount);
        map.put("transfusionCount",transfusionCount);
        map.put("treatCount",treatCount);
        return map;
    }



}

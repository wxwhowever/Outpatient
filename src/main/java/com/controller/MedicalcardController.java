package com.controller;

import com.biz.MedicalcardBiz;
import com.entity.Medicalcard;
import com.sun.xml.internal.stream.events.EndDocumentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MedicalcardController {

    @Autowired
    MedicalcardBiz medicalcardBiz;


    @ResponseBody
    @RequestMapping("queryMap")
    public Map<String,Object> queryMap(HttpServletRequest request){
        String search = request.getParameter("search");
        String page = request.getParameter("page");
        String sql = "";
        int begin = 0;
        int end = 5;
        if(page != null && page != ""){
            end = Integer.parseInt(page);
        }
        if(search != null && search != ""){
            sql = search;
        }
        Map<String,Object> map = medicalcardBiz.queryMap(sql,begin, end);

        return map;
    }


}

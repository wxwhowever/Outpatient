package com.controller;

import com.biz.Ck_infoBiz;
import com.entity.CK_info;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class Ck_infoController {

    @Autowired
    Ck_infoBiz ck_infoBiz;


    @ResponseBody
    @RequestMapping("queryMap-ck_info")
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
        Map<String,Object> map = ck_infoBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-ck_info")
    public CK_info queryById(HttpServletRequest request){
        CK_info ck_info = ck_infoBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return ck_info;
    }

//    @ResponseBody
//    @RequestMapping("insertCk_info")
//    public String insert(HttpServletRequest request) throws IOException {
//        CK_info ck_info = new ObjectMapper().readValue(request.getParameter("ck_info"), CK_info.class);
//
////        查询最大的病案号
//        String mcno = ck_infoBiz.queryMaxNo();
////        将最大的病案号加一，添加到数据库
//        int newMcno = Integer.parseInt(mcno) + 1;
////        ck_info.setMcno("MC2018"+newMcno);
////        ck_info.setCreatedate(new Date().toLocaleString());
//        String result = "";
//        boolean insert = ck_infoBiz.insert(ck_info);
//        if(insert) {
//            result = "success";
//        }
//        return result;
//    }

    @ResponseBody
    @RequestMapping("updateCk_info")
    public String update(HttpServletRequest request) throws IOException {
        CK_info ck_info = new ObjectMapper().readValue(request.getParameter("ck_info"), CK_info.class);
        String result = "";
        boolean update = ck_infoBiz.update(ck_info);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteCk_info")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = ck_infoBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
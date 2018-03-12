package com.controller;

import com.biz.WG_waitBiz;
import com.biz.YK_waitBiz;
import com.entity.WG_wait;
import com.entity.YK_wait;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class YK_waitController {

    @Autowired
    YK_waitBiz yk_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-yk_wait")
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
        Map<String,Object> map = yk_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-yk_wait")
    public YK_wait queryById(HttpServletRequest request){
        YK_wait yk_wait = yk_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return yk_wait;
    }

    @ResponseBody
    @RequestMapping("updateYk_wait")
    public String update(HttpServletRequest request) throws IOException {
        //      候诊ID
        int waitId = Integer.parseInt(request.getParameter("waitId"));
//      选择调整的等级
        String level = request.getParameter("level");
        String result = "";
//        根据得到 id 调整队列,设置优先级
        YK_wait yk_wait = yk_waitBiz.queryById(waitId);
        yk_wait.setLevel(level);
        boolean update = yk_waitBiz.update(yk_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteYk_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = yk_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
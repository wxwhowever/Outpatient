package com.controller;

import com.biz.NK_waitBiz;
import com.entity.CK_wait;
import com.entity.NK_wait;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class NK_waitController {

    @Autowired
    NK_waitBiz nk_waitBiz;



    @ResponseBody
    @RequestMapping("queryMap-nk_wait")
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
        Map<String,Object> map = nk_waitBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-nk_wait")
    public NK_wait queryById(HttpServletRequest request){
        NK_wait mz_wait = nk_waitBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return mz_wait;
    }

    @ResponseBody
    @RequestMapping("updateNk_wait")
    public String update(HttpServletRequest request) throws IOException {
  //      候诊ID
        int waitId = Integer.parseInt(request.getParameter("waitId"));
//      选择调整的等级
        String level = request.getParameter("level");
        String result = "";
//        根据得到 id 调整队列,设置优先级
        NK_wait nk_wait = nk_waitBiz.queryById(waitId);
        nk_wait.setLevel(level);
        boolean update = nk_waitBiz.update(nk_wait);
        if(update) {
            result = "success";
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteNk_wait")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = nk_waitBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }

}
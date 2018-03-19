package com.controller;

import com.alibaba.fastjson.JSON;
import com.biz.Ck_waitBiz;
import com.biz.UserBiz;
import com.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserBiz userBiz;
    private List<Map<String, Object>> maps;

//    @ResponseBody
//    @RequestMapping("userLogin")
//    public String userLogins(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String result = "0";
//
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//
//        try {
//            subject.login(token);
//            boolean authenticated = subject.isAuthenticated();
//        }catch (Exception e){
//            result = "1";
//        }
//        return result ;
//    }





    @RequestMapping("userLogin")
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String result = "";
        User user = userBiz.login(name, password);
        if(user != null){
            maps = userBiz.queryPower(user.getUid());
            result = "main";
        }
        else{
            result = "login";
//            result = "/login";//13975361880
        }
        session.setAttribute("power",maps);
        return result;
    }




    /**
     * 判断登录是否成功
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String result = "0";
        User user = userBiz.login(name, password);
        if(user == null){
            result = "1";
        }
        return result;
    }


    /**
     * 查询用户的所有权限
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("powerList")
    public Object powerList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object power = session.getAttribute("power");
        System.out.println("用户有的权限："+power);

        return power;
    }


}
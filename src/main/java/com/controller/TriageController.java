package com.controller;

import com.biz.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class TriageController {

    @Autowired
    TriageBiz triageBiz;
    @Autowired
    RegistrationBiz registrationBiz;
    @Autowired
    Ck_waitBiz ck_waitBiz;
    @Autowired
    com.biz.kQ_waitBiz kQ_waitBiz;
    @Autowired
    MZ_waitBiz mz_waitBiz;
    @Autowired
    NK_waitBiz nk_waitBiz;
    @Autowired
    SJ_waitBiz sj_waitBiz;
    @Autowired
    TX_waitBiz tx_waitBiz;
    @Autowired
    WK_waitBiz wk_waitBiz;
    @Autowired
    WG_waitBiz wg_waitBiz;
    @Autowired
    YK_waitBiz yk_waitBiz;
    @Autowired
    ZY_waitBiz zy_waitBiz;
    @Autowired
    EK_waitBiz ek_waitBiz;
    @Autowired
    PatientBiz patientBiz;

    @ResponseBody
    @RequestMapping("queryMap-triage")
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
        Map<String,Object> map = triageBiz.queryMap(sql,begin, end);

        return map;
    }

    @ResponseBody
    @RequestMapping("queryById-triage")
    public Triage queryById(HttpServletRequest request){
        Triage triage = triageBiz.queryById(Integer.parseInt(request.getParameter("id")));
        return triage;
    }


    @ResponseBody
    @RequestMapping("deleteTriae")
    public String delete(HttpServletRequest request) throws IOException {
        String result = "";
        boolean delete = triageBiz.delete(Integer.parseInt(request.getParameter("id")));
        if(delete) {
            result = "success";
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("triageInsert")
    public String triageInsert(HttpServletRequest request) throws IOException {
//        分配病人的挂号编号
        String rsno = request.getParameter("rsno");
 //        分配表的编号，分配后标记为已分配
        String triageId = request.getParameter("triageId");
        Triage triage1 = triageBiz.queryById(triageId);
        triage1.setState(1);
        triageBiz.update(triage1);

//        分配的科的编号
        int triage = Integer.parseInt(request.getParameter("triage"));

//        根据挂号编号查询病人表
        Patient patient = patientBiz.queryByRsno(rsno);

        String result = "";

//        根据分配的科添加
        if(triage==1){
            CK_wait ck_wait = new CK_wait();
            int wno = Integer.parseInt(ck_waitBiz.queryMaxNo())+1;
            ck_wait.setWno("CKWNO2018"+wno);
            ck_wait.setPno(patient.getPno());
            ck_wait.setName(patient.getName());
            ck_wait.setSex(patient.getSex());
            ck_wait.setAge(patient.getAge());
            ck_wait.setType(patient.getType());
            ck_wait.setRemark(patient.getRemark());
            ck_wait.setLevel("3");
            ck_wait.setDate(new Date().toLocaleString());
            ck_wait.setJzno(patient.getJzno());
            ck_wait.setDno("d201812");
            ck_waitBiz.insert(ck_wait);
            result = "success";
        }
        else if(triage==2){
            KQ_wait kq_wait = new KQ_wait();
            int wno = Integer.parseInt(kQ_waitBiz.queryMaxNo())+1;
            kq_wait.setWno("KQWNO2018"+wno);
            kq_wait.setPno(patient.getPno());
            kq_wait.setName(patient.getName());
            kq_wait.setSex(patient.getSex());
            kq_wait.setAge(patient.getAge());
            kq_wait.setType(patient.getType());
            kq_wait.setRemark(patient.getRemark());
            kq_wait.setLevel("3");
            kq_wait.setDate(new Date().toLocaleString());
            kq_wait.setJzno(patient.getJzno());
            kq_wait.setDno("d201812");
            kQ_waitBiz.insert(kq_wait);
            result = "success";
        }
        else if(triage==3){
            MZ_wait mz_wait = new MZ_wait();
            int wno = Integer.parseInt(mz_waitBiz.queryMaxNo())+1;
            mz_wait.setWno("MZWNO2018"+wno);
            mz_wait.setPno(patient.getPno());
            mz_wait.setName(patient.getName());
            mz_wait.setSex(patient.getSex());
            mz_wait.setAge(patient.getAge());
            mz_wait.setType(patient.getType());
            mz_wait.setRemark(patient.getRemark());
            mz_wait.setLevel("3");
            mz_wait.setDate(new Date().toLocaleString());
            mz_wait.setJzno(patient.getJzno());
            mz_wait.setDno("d201812");
            mz_waitBiz.insert(mz_wait);
            result = "success";
        }
        else if(triage==4){
            NK_wait nk_wait = new NK_wait();
            int wno = Integer.parseInt(nk_waitBiz.queryMaxNo())+1;
            nk_wait.setWno("NKWNO2018"+wno);
            nk_wait.setPno(patient.getPno());
            nk_wait.setName(patient.getName());
            nk_wait.setSex(patient.getSex());
            nk_wait.setAge(patient.getAge());
            nk_wait.setType(patient.getType());
            nk_wait.setRemark(patient.getRemark());
            nk_wait.setLevel("3");
            nk_wait.setDate(new Date().toLocaleString());
            nk_wait.setJzno(patient.getJzno());
            nk_wait.setDno("d201812");
            nk_waitBiz.insert(nk_wait);
            result = "success";
        }
        else if(triage==5){
            SJ_wait sj_wait = new SJ_wait();
            int wno = Integer.parseInt(sj_waitBiz.queryMaxNo())+1;
            sj_wait.setWno("SJWNO2018"+wno);
            sj_wait.setPno(patient.getPno());
            sj_wait.setName(patient.getName());
            sj_wait.setSex(patient.getSex());
            sj_wait.setAge(patient.getAge());
            sj_wait.setType(patient.getType());
            sj_wait.setRemark(patient.getRemark());
            sj_wait.setLevel("3");
            sj_wait.setDate(new Date().toLocaleString());
            sj_wait.setJzno(patient.getJzno());
            sj_wait.setDno("d201812");
            sj_waitBiz.insert(sj_wait);
            result = "success";
        }
        else if(triage==6){
            WK_wait wk_wait = new WK_wait();
            int wno = Integer.parseInt(wk_waitBiz.queryMaxNo())+1;
            wk_wait.setWno("WKWNO2018"+wno);
            wk_wait.setPno(patient.getPno());
            wk_wait.setName(patient.getName());
            wk_wait.setSex(patient.getSex());
            wk_wait.setAge(patient.getAge());
            wk_wait.setType(patient.getType());
            wk_wait.setRemark(patient.getRemark());
            wk_wait.setLevel("3");
            wk_wait.setDate(new Date().toLocaleString());
            wk_wait.setJzno(patient.getJzno());
            wk_wait.setDno("d201812");
            wk_waitBiz.insert(wk_wait);
            result = "success";
        }
        else if(triage==7){
            WG_wait wg_wait = new WG_wait();
            int wno = Integer.parseInt(wg_waitBiz.queryMaxNo())+1;
            wg_wait.setWno("WGWNO2018"+wno);
            wg_wait.setPno(patient.getPno());
            wg_wait.setName(patient.getName());
            wg_wait.setSex(patient.getSex());
            wg_wait.setAge(patient.getAge());
            wg_wait.setType(patient.getType());
            wg_wait.setRemark(patient.getRemark());
            wg_wait.setLevel("3");
            wg_wait.setDate(new Date().toLocaleString());
            wg_wait.setJzno(patient.getJzno());
            wg_wait.setDno("d201812");
            wg_waitBiz.insert(wg_wait);
            result = "success";
        }
        else if(triage==8){
            TX_wait tx_wait = new TX_wait();
            int wno = Integer.parseInt(tx_waitBiz.queryMaxNo())+1;
            tx_wait.setWno("TXWNO2018"+wno);
            tx_wait.setPno(patient.getPno());
            tx_wait.setName(patient.getName());
            tx_wait.setSex(patient.getSex());
            tx_wait.setAge(patient.getAge());
            tx_wait.setType(patient.getType());
            tx_wait.setRemark(patient.getRemark());
            tx_wait.setLevel("3");
            tx_wait.setDate(new Date().toLocaleString());
            tx_wait.setJzno(patient.getJzno());
            tx_wait.setDno("d201812");
            tx_waitBiz.insert(tx_wait);
            result = "success";
        }
        else if(triage==9){
            YK_wait yk_wait = new YK_wait();
            int wno = Integer.parseInt(yk_waitBiz.queryMaxNo())+1;
            yk_wait.setWno("YKWNO2018"+wno);
            yk_wait.setPno(patient.getPno());
            yk_wait.setName(patient.getName());
            yk_wait.setSex(patient.getSex());
            yk_wait.setAge(patient.getAge());
            yk_wait.setType(patient.getType());
            yk_wait.setRemark(patient.getRemark());
            yk_wait.setLevel("3");
            yk_wait.setDate(new Date().toLocaleString());
            yk_wait.setJzno(patient.getJzno());
            yk_wait.setDno("d201812");
            yk_waitBiz.insert(yk_wait);
            result = "success";
        }
        else if(triage==10){
            ZY_wait zy_wait = new ZY_wait();
            int wno = Integer.parseInt(zy_waitBiz.queryMaxNo())+1;
            zy_wait.setWno("ZYWNO2018"+wno);
            zy_wait.setPno(patient.getPno());
            zy_wait.setName(patient.getName());
            zy_wait.setSex(patient.getSex());
            zy_wait.setAge(patient.getAge());
            zy_wait.setType(patient.getType());
            zy_wait.setRemark(patient.getRemark());
            zy_wait.setLevel("3");
            zy_wait.setDate(new Date().toLocaleString());
            zy_wait.setJzno(patient.getJzno());
            zy_wait.setDno("d201812");
            zy_waitBiz.insert(zy_wait);
            result = "success";
        }
        else if(triage==11){
            EK_wait ek_wait = new EK_wait();
            int wno = Integer.parseInt(ek_waitBiz.queryMaxNo())+1;
            ek_wait.setWno("EKWNO2018"+wno);
            ek_wait.setPno(patient.getPno());
            ek_wait.setName(patient.getName());
            ek_wait.setSex(patient.getSex());
            ek_wait.setAge(patient.getAge());
            ek_wait.setType(patient.getType());
            ek_wait.setRemark(patient.getRemark());
            ek_wait.setLevel("3");
            ek_wait.setDate(new Date().toLocaleString());
            ek_wait.setJzno(patient.getJzno());
            ek_wait.setDno("d201812");
            ek_waitBiz.insert(ek_wait);
            result = "success";
        }

        return result;
    }

}
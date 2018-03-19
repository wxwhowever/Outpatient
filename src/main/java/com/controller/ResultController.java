package com.controller;

import com.biz.ASTdrugBiz;
import com.biz.InjectdrugBiz;
import com.biz.PrescribeBiz;
import com.biz.TransfusionBiz;
import com.entity.ASTdrug;
import com.entity.Injectdrug;
import com.entity.Prescribe;
import com.entity.Transfusion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
public class ResultController {

    @Autowired
    PrescribeBiz prescribeBiz;//开药单
    @Autowired
    ASTdrugBiz asTdrugBiz;//皮试用药单
    @Autowired
    InjectdrugBiz injectdrugBiz;//注射用药单
    @Autowired
    TransfusionBiz transfusionBiz;//输液用药单

    @ResponseBody
    @RequestMapping("/addPrescribe")
    public String addPrescribe(HttpServletRequest request) throws Exception {
        String pno = request.getParameter("pno");
        Prescribe prescribe = new ObjectMapper().readValue(request.getParameter("addobject"), Prescribe.class);
        String result = "";

        if (prescribe != null) {
            int maxNo = Integer.parseInt(prescribeBiz.queryMaxNo()) + 1;
            Prescribe prescribe1 = new Prescribe();
            prescribe1.setPno("pno20180" + maxNo);
            prescribe1.setPatient_pno(pno);
            prescribe1.setDoctor_dno("d201812");
            prescribe1.setDrug_dno(prescribe.getDrug_dno());
            prescribe1.setDrugnum(prescribe.getDrugnum());
            prescribe1.setTotal(prescribe.getTotal());
            prescribe1.setRemarks(prescribe.getRemarks());
            prescribe1.setDate(new Date().toLocaleString());
            prescribe1.setState("0");
            boolean insert = prescribeBiz.insert(prescribe1);
            if(insert){
                result = "success";
            }
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/addAstdrug")
    public String addAstdrug(HttpServletRequest request) throws Exception {
        String pno = request.getParameter("pno");
        ASTdrug astdrug = new ObjectMapper().readValue(request.getParameter("astdrug"), ASTdrug.class);
        String result = "";
        if (astdrug != null) {
            int maxNo = Integer.parseInt(asTdrugBiz.queryMaxNo()) + 1;
            ASTdrug asTdrugAdd = new ASTdrug();
            asTdrugAdd.setSkinno("sno20180" + maxNo);
            asTdrugAdd.setPatient_pno(pno);
            asTdrugAdd.setDoctor_dno("d201812");
            asTdrugAdd.setDrug_dno(astdrug.getDrug_dno());
            asTdrugAdd.setMmol(astdrug.getMmol());
            asTdrugAdd.setDrugnum(astdrug.getDrugnum());
            asTdrugAdd.setTotal(astdrug.getTotal());
            asTdrugAdd.setRemarks(astdrug.getRemarks());
            asTdrugAdd.setDate(new Date().toLocaleString());
            asTdrugAdd.setState(0);
            boolean insert = asTdrugBiz.insert(asTdrugAdd);
            if(insert){
                result = "success";
            }
        }
        return  result;
    }

    @ResponseBody
    @RequestMapping("/addInjectdrug")
    public String addInjectdrug(HttpServletRequest request) throws Exception {
        String pno = request.getParameter("pno");
        Injectdrug injectdrug = new ObjectMapper().readValue(request.getParameter("addobject"), Injectdrug.class);
        if (injectdrug != null) {
            int maxNo = Integer.parseInt(injectdrugBiz.queryMaxNo()) + 1;
            Injectdrug injectdrugAdd = new Injectdrug();
            injectdrugAdd.setIno("ino20180" + maxNo);
            injectdrugAdd.setPatient_pno(pno);
            injectdrugAdd.setDoctor_dno("d201812");
            injectdrugAdd.setDrug_dno(injectdrug.getDrug_dno());
            injectdrugAdd.setDrugnum(injectdrug.getDrugnum());
            injectdrugAdd.setTotal(injectdrug.getTotal());
            injectdrugAdd.setRemarks(injectdrug.getRemarks());
            injectdrugAdd.setDate(new Date().toLocaleString());
            injectdrugAdd.setState("0");
            boolean insert = injectdrugBiz.insert(injectdrugAdd);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/addTransfusion")
    public String addTransfusion(HttpServletRequest request) throws Exception {
        String pno = request.getParameter("pno");
        Transfusion transfusion = new ObjectMapper().readValue(request.getParameter("addobject"), Transfusion.class);
        String result = "";
        if(transfusion != null){
            int maxNo = Integer.parseInt(transfusionBiz.queryMaxNo())+1;
            Transfusion transfusionAdd = new Transfusion();
            transfusionAdd.setTno("tno20180"+maxNo);
            transfusionAdd.setPatient_pno(pno);
            transfusionAdd.setDoctor_dno("d201812");
            transfusionAdd.setDrug_dno(transfusion.getDrug_dno());
            transfusionAdd.setDrugnum(transfusion.getDrugnum());
            transfusionAdd.setTotal(transfusion.getTotal());
            transfusionAdd.setRemarks(transfusion.getRemarks());
            transfusionAdd.setDate(new Date().toLocaleString());
            transfusionAdd.setState("0");
            boolean insert =  transfusionBiz.insert(transfusionAdd);
            if(insert){
                result = "success";
            }
        }
        return result;
    }

}
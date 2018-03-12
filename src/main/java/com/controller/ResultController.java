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
    @RequestMapping("/addResult")
    public String addResult(HttpServletRequest request) throws Exception {

        String pno = request.getParameter("pno");
        Prescribe prescribe = new ObjectMapper().readValue( request.getParameter("prescribe"),Prescribe.class);
        ASTdrug astdrug = new ObjectMapper().readValue( request.getParameter("astdrug"),ASTdrug.class);
        Injectdrug injectdrug = new ObjectMapper().readValue( request.getParameter("injectdrug"),Injectdrug.class);
        Transfusion transfusion = new ObjectMapper().readValue( request.getParameter("transfusion"),Transfusion.class);

        if(prescribe != null){
            int maxNo = Integer.parseInt(prescribeBiz.queryMaxNo())+1;
            Prescribe prescribe1 = new Prescribe();
            prescribe1.setPno("pno20180"+maxNo);
            prescribe1.setPatient_pno(pno);
            prescribe1.setDoctor_dno("");
            prescribe1.setDrug_dno(prescribe.getDrug_dno());
            prescribe1.setDrugnum(prescribe.getDrugnum());
            prescribe1.setTotal(prescribe.getTotal());
            prescribe1.setRemarks(prescribe.getRemarks());
            prescribe1.setDate(new Date().toLocaleString());
            prescribe1.setState("0");
            prescribeBiz.insert(prescribe1);
        }
        if(astdrug != null){
            int maxNo = Integer.parseInt(asTdrugBiz.queryMaxNo())+1;
            ASTdrug asTdrugAdd = new ASTdrug();
            asTdrugAdd.setSkinno("sno20180"+maxNo);
            asTdrugAdd.setPatient_pno(pno);
            asTdrugAdd.setDoctor_dno("");
            asTdrugAdd.setDrug_dno(astdrug.getDrug_dno());
            asTdrugAdd.setMmol(astdrug.getMmol());
            asTdrugAdd.setSum(astdrug.getSum());
            asTdrugAdd.setRemarks(astdrug.getRemarks());
            asTdrugAdd.setDate(new Date().toLocaleString());
            asTdrugAdd.setState("0");
            prescribeBiz.insert(astdrug);
        }
        if(injectdrug != null){
            int maxNo = Integer.parseInt(prescribeBiz.queryMaxNo())+1;
            Injectdrug injectdrugAdd = new Injectdrug();
            injectdrugAdd.setIno("ino20180"+maxNo);
            injectdrugAdd.setPatient_pno(pno);
            injectdrugAdd.setDoctor_dno("");
            injectdrugAdd.setDrug_dno(injectdrug.getDrug_dno());
            injectdrugAdd.setDosage(injectdrug.getDosage());
            injectdrugAdd.setRemarks(injectdrug.getRemarks());
            injectdrugAdd.setDate(new Date().toLocaleString());
            injectdrugAdd.setState("0");
            prescribeBiz.insert(injectdrugAdd);
        }
        if(transfusion != null){
            int maxNo = Integer.parseInt(prescribeBiz.queryMaxNo())+1;
            Transfusion transfusionAdd = new Transfusion();
            transfusionAdd.setTno("tno20180"+maxNo);
            transfusionAdd.setPatient_pno(pno);
            transfusionAdd.setDoctor_dno("");
            transfusionAdd.setDrug_dno(transfusion.getDrug_dno());
            transfusionAdd.setDosage(transfusion.getDosage());
            transfusionAdd.setSum(transfusion.getSum());
            transfusionAdd.setRemarks(transfusion.getRemarks());
            transfusionAdd.setDate(new Date().toLocaleString());
            transfusionAdd.setState("0");
            prescribeBiz.insert(transfusionAdd);
        }

        return null;
    }

}

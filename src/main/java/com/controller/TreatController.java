package com.controller;

import com.biz.ASTdrugBiz;
import com.biz.TreatBiz;
import com.entity.ASTdrug;
import com.entity.Treat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreatController {
    @Autowired
    TreatBiz treatBiz;

    @Autowired
    ASTdrugBiz asTdrugBiz;

    @ResponseBody
    @RequestMapping("treat_resultmap")
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
        List<Treat> list = treatBiz.resultMap(param,begin, end);
        int maxCount = treatBiz.getCount(param);
        int maxPage = (maxCount/end) + ((maxCount%end) !=0 ? 1 : 0);
        map.put("listData",list);
        map.put("maxPage",maxPage);
        return map;
    }

    @ResponseBody
    @RequestMapping("addTreat")
    public String addTreat(HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String pno = request.getParameter("pno");
        String dno = request.getParameter("dno");
        String result = request.getParameter("result");
        Treat treat = new Treat();
        String tno = treatBiz.queryMaxNo();
        int newTno = Integer.parseInt(tno)+1;
        String enddate = new Date().toLocaleString();
        treat.settreatno("t2018"+newTno);
        treat.setPatient_pno(pno);
        treat.setDoctor_dno(dno);
        treat.setResult(result);
        treat.setState(1);
        treat.setEnddate(enddate);
        String types = type.substring(0,1);
        if (types.equals("s")){
            treat.setType("皮试治疗");
        }
        String a = "";
        boolean f = treatBiz.insert(treat);
        ASTdrug asTdrug =  asTdrugBiz.queryById(Integer.parseInt(id));
        System.out.println("--------------"+asTdrug);
        asTdrug.setState(1);
        boolean flag = asTdrugBiz.update(asTdrug);
        System.out.println("oooo----"+flag);
        if(f){
            a = "success";
        }
        return a;
    }

}

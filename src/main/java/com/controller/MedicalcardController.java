package com.controller;

import com.biz.MedicalcardBiz;
import com.entity.Medicalcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MedicalcardController {

    @Autowired
    MedicalcardBiz medicalcardBiz;


    @RequestMapping("index")
    public void index(){
        List<Medicalcard> medicalcards = medicalcardBiz.queryList();
        for (Medicalcard medicalcard : medicalcards) {
            System.out.println(medicalcard);
        }
        System.out.println("ok");

    }
}

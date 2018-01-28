package com.entity;

import java.io.Serializable;

public class Patient{

    private int id;
//    病人编号
    private String PNO;
//    患者姓名
    private String name;
//    身份证号
    private String card;
//    患病类型
    private String type;
//    患病描述
    private String remark;
//    性别
    private String sex;
//    年龄
    private int age;
//    职业
    private String  profession;
//    地址
    private String address;
//    病案时间
    private String createdate;
//    电话
    private String phone;
//    挂号编号
    private Registration registration;
//    就诊卡
    private Medicalcard medicalcard;
//    医保卡
    private Medicarecard medicarecard;
//    银医卡
    private Doctorcard doctorcard;

    public Patient() {
    }

    public Patient(String PNO, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Registration registration, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {
        this.PNO = PNO;
        this.name = name;
        this.card = card;
        this.type = type;
        this.remark = remark;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.createdate = createdate;
        this.phone = phone;
        this.registration = registration;
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
        this.doctorcard = doctorcard;
    }

    public Patient(int id, String PNO, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Registration registration, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {

        this.id = id;
        this.PNO = PNO;
        this.name = name;
        this.card = card;
        this.type = type;
        this.remark = remark;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.createdate = createdate;
        this.phone = phone;
        this.registration = registration;
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
        this.doctorcard = doctorcard;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", PNO='" + PNO + '\'' +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", createdate='" + createdate + '\'' +
                ", phone='" + phone + '\'' +
                ", registration=" + registration +
                ", medicalcard=" + medicalcard +
                ", medicarecard=" + medicarecard +
                ", doctorcard=" + doctorcard +
                '}';
    }
}

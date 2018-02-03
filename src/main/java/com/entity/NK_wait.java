package com.entity;

import java.util.List;

/**
 * 内科候诊表
 */
public class NK_wait {

    private int id;
//    候诊编号
    private String wno;
//    病人编号
    private List<Patient> patientList;
//    姓名
    private String name;
//    性别
    private String sex;
//    年龄
    private int age;
//    患病类型
    private String  type;
//    患病描述
    private String  remark;
//    患病等级
    private String  level;
//    候诊时间
    private String date;
//    就诊卡卡号
    private Medicalcard medicalcard;
//    分诊人
    private Doctor doctor;


    public NK_wait() {
    }

    public NK_wait(int id, String wno, List<Patient> patientList, String name, String sex, int age, String type, String remark, String level, String date, Medicalcard medicalcard, Doctor doctor) {
        this.id = id;
        this.wno = wno;
        this.patientList = patientList;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
        this.level = level;
        this.date = date;
        this.medicalcard = medicalcard;
        this.doctor = doctor;
    }
    public NK_wait(String wno, List<Patient> patientList, String name, String sex, int age, String type, String remark, String level, String date, Medicalcard medicalcard, Doctor doctor) {
        this.wno = wno;
        this.patientList = patientList;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
        this.level = level;
        this.date = date;
        this.medicalcard = medicalcard;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Medicalcard getMedicalcard() {
        return medicalcard;
    }

    public void setMedicalcard(Medicalcard medicalcard) {
        this.medicalcard = medicalcard;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "CK_wait{" +
                "id=" + id +
                ", wno='" + wno + '\'' +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", level='" + level + '\'' +
                ", date='" + date + '\'' +
                ", medicalcard=" + medicalcard +
                ", doctor=" + doctor +
                '}';
    }
}

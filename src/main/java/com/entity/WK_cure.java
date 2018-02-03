package com.entity;

import java.util.List;

/**
 * 外科换药治疗表
 */
public class WK_cure {

    private int id;
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
//    治疗时间
    private String date;
//    就诊卡卡号
    private Medicalcard medicalcard;
//    治疗医生
    private Doctor doctor;

    public WK_cure() {
    }

    public WK_cure(int id, List<Patient> patientList, String name, String sex, int age, String type, String remark, String date, Medicalcard medicalcard, Doctor doctor) {
        this.id = id;
        this.patientList = patientList;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
        this.date = date;
        this.medicalcard = medicalcard;
        this.doctor = doctor;
    }

    public WK_cure(List<Patient> patientList, String name, String sex, int age, String type, String remark, String date, Medicalcard medicalcard, Doctor doctor) {
        this.patientList = patientList;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
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
        return "WK_cure{" +
                "id=" + id +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", date='" + date + '\'' +
                ", medicalcard=" + medicalcard +
                ", doctor=" + doctor +
                '}';
    }
}

package com.entity;

import java.util.List;

/**
 * 产科表
 */
public class CK_change {

    private int id;
//    候诊编号
    private String CNO;
//    病人编号
    private List<Patient> patientList;
//    姓名
    private String name;
//    转科原因
    private String  remark;
//    记录时间
    private String date;
//    就诊卡卡号
    private Medicalcard medicalcard;
//    记录人
    private Doctor doctor;

    public CK_change() {
    }

    public CK_change(int id, String CNO, List<Patient> patientList, String name, String remark, String date, Medicalcard medicalcard, Doctor doctor) {
        this.id = id;
        this.CNO = CNO;
        this.patientList = patientList;
        this.name = name;
        this.remark = remark;
        this.date = date;
        this.medicalcard = medicalcard;
        this.doctor = doctor;
    }

    public CK_change(String CNO, List<Patient> patientList, String name, String remark, String date, Medicalcard medicalcard, Doctor doctor) {
        this.CNO = CNO;
        this.patientList = patientList;
        this.name = name;
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

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
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
        return "CK_change{" +
                "id=" + id +
                ", CNO='" + CNO + '\'' +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", date='" + date + '\'' +
                ", medicalcard=" + medicalcard +
                ", doctor=" + doctor +
                '}';
    }
}

package com.entity;

import java.util.List;

/**
 * 产科超额登记表
 */
public class CK_overfulfil {

    private int id;
//    登记编号
    private String ofno;
//    病人编号
    private List<Patient> patientList;
//    姓名
    private String name;
//    候诊时间
    private String date;
//    分诊人
    private Doctor doctor;


    public CK_overfulfil() {
    }

    public CK_overfulfil(int id, String ofno, List<Patient> patientList, String name, String date, Doctor doctor) {
        this.id = id;
        this.ofno = ofno;
        this.patientList = patientList;
        this.name = name;
        this.date = date;
        this.doctor = doctor;
    }

    public CK_overfulfil(String ofno, List<Patient> patientList, String name, String date, Doctor doctor) {
        this.ofno = ofno;
        this.patientList = patientList;
        this.name = name;
        this.date = date;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfno() {
        return ofno;
    }

    public void setOfno(String ofno) {
        this.ofno = ofno;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "CK_overfulfil{" +
                "id=" + id +
                ", ofno='" + ofno + '\'' +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}

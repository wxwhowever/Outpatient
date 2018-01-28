package com.entity;

import java.util.List;

/**
 * 产科表
 */
public class CK_overfulfil {

    private int id;
//    登记编号
    private String OFNO;
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

    public CK_overfulfil(int id, String OFNO, List<Patient> patientList, String name, String date, Doctor doctor) {
        this.id = id;
        this.OFNO = OFNO;
        this.patientList = patientList;
        this.name = name;
        this.date = date;
        this.doctor = doctor;
    }

    public CK_overfulfil(String OFNO, List<Patient> patientList, String name, String date, Doctor doctor) {
        this.OFNO = OFNO;
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

    public String getOFNO() {
        return OFNO;
    }

    public void setOFNO(String OFNO) {
        this.OFNO = OFNO;
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
                ", OFNO='" + OFNO + '\'' +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}

package com.entity;

import java.util.List;

/**
 * 产科信息记录表
 */
public class CK_info {

    private int id;
//    产科记录编号
    private String CKNO;
//    病人编号
    private List<Patient> patientList;
//    姓名
    private String name;
//    身高
    private String height;
//    体重
    private int weight;
//    记录人
    private Doctor doctor;
    //    就诊卡卡号
    private Medicalcard medicalcard;
    //    记录时间
    private String date;


    public CK_info() {
    }

    public CK_info(int id, String CKNO, List<Patient> patientList, String name, String height, int weight, Doctor doctor, Medicalcard medicalcard, String date) {
        this.id = id;
        this.CKNO = CKNO;
        this.patientList = patientList;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.doctor = doctor;
        this.medicalcard = medicalcard;
        this.date = date;
    }

    public CK_info(String CKNO, List<Patient> patientList, String name, String height, int weight, Doctor doctor, Medicalcard medicalcard, String date) {
        this.CKNO = CKNO;
        this.patientList = patientList;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.doctor = doctor;
        this.medicalcard = medicalcard;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCKNO() {
        return CKNO;
    }

    public void setCKNO(String CKNO) {
        this.CKNO = CKNO;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicalcard getMedicalcard() {
        return medicalcard;
    }

    public void setMedicalcard(Medicalcard medicalcard) {
        this.medicalcard = medicalcard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CK_info{" +
                "id=" + id +
                ", CKNO='" + CKNO + '\'' +
                ", patientList=" + patientList +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight=" + weight +
                ", doctor=" + doctor +
                ", medicalcard=" + medicalcard +
                ", date='" + date + '\'' +
                '}';
    }
}

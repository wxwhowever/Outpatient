package com.entity;

//治疗单
public class Treat {

    private int id;

    private String tno;//编号

    private Patient patient_pno;//患者

    private Doctor doctor_dno;//医生

    private String date;//治疗时间

    public Treat() {
    }

    public Treat(int id, String tno, Patient patient_pno, Doctor doctor_dno, String date) {
        this.id = id;
        this.tno = tno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Patient getPatient_pno() {
        return patient_pno;
    }

    public void setPatient_pno(Patient patient_pno) {
        this.patient_pno = patient_pno;
    }

    public Doctor getDoctor_dno() {
        return doctor_dno;
    }

    public void setDoctor_dno(Doctor doctor_dno) {
        this.doctor_dno = doctor_dno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

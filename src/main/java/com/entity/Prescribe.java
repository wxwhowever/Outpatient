package com.entity;

import java.util.List;

//开药单
public class Prescribe {
    private int id;//自动增长编号

    private String pno;//药单编号

    private String  patient_pno;//患者编号

    private String  doctor_dno;//开药医师

    private String  drug_dno;//药品

    private String drugnum;//发药量

    private double total;//总计

    private String remarks;//备注

    private String date;//开单时间

    private String state;

    public Prescribe() {
    }

    public Prescribe(int id, String pno, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.id = id;
        this.pno = pno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.drugnum = drugnum;
        this.total = total;
        this.remarks = remarks;
        this.date = date;
        this.state = state;
    }

    public Prescribe(String pno, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.pno = pno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.drugnum = drugnum;
        this.total = total;
        this.remarks = remarks;
        this.date = date;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPatient_pno() {
        return patient_pno;
    }

    public void setPatient_pno(String patient_pno) {
        this.patient_pno = patient_pno;
    }

    public String getDoctor_dno() {
        return doctor_dno;
    }

    public void setDoctor_dno(String doctor_dno) {
        this.doctor_dno = doctor_dno;
    }

    public String getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(String drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getDrugnum() {
        return drugnum;
    }

    public void setDrugnum(String drugnum) {
        this.drugnum = drugnum;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Prescribe{" +
                "id=" + id +
                ", pno='" + pno + '\'' +
                ", patient_pno='" + patient_pno + '\'' +
                ", doctor_dno='" + doctor_dno + '\'' +
                ", drug_dno='" + drug_dno + '\'' +
                ", drugnum='" + drugnum + '\'' +
                ", total=" + total +
                ", remarks='" + remarks + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

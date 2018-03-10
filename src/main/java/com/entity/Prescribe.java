package com.entity;

import java.util.List;

//开药单
public class Prescribe {
    private int id;//自动增长编号

    private String pno;//药单编号

    private Patient patient_pno;//患者编号

    private List<Doctor> doctor_dno;//开药医师

    private List<Drug> drug_dno;//药品

    private String drugnum;//发药量

    private double sum;//总计

    private String remarks;//备注

    private String date;//开单时间

    public Prescribe() {
    }

    public Prescribe(int id, String pno, Patient patient_pno, List<Doctor> doctor_dno, List<Drug> drug_dno, String drugnum, double sum, String remarks, String date) {
        this.id = id;
        this.pno = pno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.drugnum = drugnum;
        this.sum = sum;
        this.remarks = remarks;
        this.date = date;
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

    public Patient getPatient_pno() {
        return patient_pno;
    }

    public void setPatient_pno(Patient patient_pno) {
        this.patient_pno = patient_pno;
    }

    public List<Doctor> getDoctor_dno() {
        return doctor_dno;
    }

    public void setDoctor_dno(List<Doctor> doctor_dno) {
        this.doctor_dno = doctor_dno;
    }

    public List<Drug> getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(List<Drug> drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getDrugnum() {
        return drugnum;
    }

    public void setDrugnum(String drugnum) {
        this.drugnum = drugnum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
}

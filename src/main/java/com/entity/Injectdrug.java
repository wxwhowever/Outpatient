package com.entity;

public class Injectdrug {
    private int id;

    private String ino;//编号

    private Patient patient_pno;//患者编号

    private Doctor doctor_dno;//医师编号

    private Drug drug_dno;//药品

    private String dosage;//剂量

    private double sum;//合计

    private String remarks;//备注

    private  String date;//开药时间

    public Injectdrug() {
    }

    public Injectdrug(int id, String ino, Patient patient_pno, Doctor doctor_dno, Drug drug_dno, String dosage, double sum, String remarks, String date) {
        this.id = id;
        this.ino = ino;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.dosage = dosage;
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

    public String getIno() {
        return ino;
    }

    public void setIno(String ino) {
        this.ino = ino;
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

    public Drug getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(Drug drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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

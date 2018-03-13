package com.entity;

public class Injectdrug {
    private int id;

    private String ino;//编号

    private String patient_pno;//患者编号

    private String doctor_dno;//医师编号

    private String drug_dno;//药品

    private String drugnum;//剂量

    private double total;//合计

    private String remarks;//备注

    private  String date;//开药时间

    private String state;

    public Injectdrug() {
    }

    public Injectdrug(String ino, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.ino = ino;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.drugnum = drugnum;
        this.total = total;
        this.remarks = remarks;
        this.date = date;
        this.state = state;
    }

    public Injectdrug(int id, String ino, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.id = id;
        this.ino = ino;
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

    public String getIno() {
        return ino;
    }

    public void setIno(String ino) {
        this.ino = ino;
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
        return "Injectdrug{" +
                "id=" + id +
                ", ino='" + ino + '\'' +
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

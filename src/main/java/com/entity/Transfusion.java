package com.entity;

//输液用药单
public class Transfusion {

    private int id;

    private String tno;//编号

    private String patient_pno;//患者

    private String doctor_dno;//医生

    private String drug_dno;//药品

    private String drugnum;//剂量

    private double total;//合计

    private String remarks;//备注

    private String date;//开药时间

    private String state;

    public Transfusion() {
    }


    public Transfusion(String tno, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.tno = tno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.drugnum = drugnum;
        this.total = total;
        this.remarks = remarks;
        this.date = date;
        this.state = state;
    }

    public Transfusion(int id, String tno, String patient_pno, String doctor_dno, String drug_dno, String drugnum, double total, String remarks, String date, String state) {
        this.id = id;
        this.tno = tno;
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

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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
        return "Transfusion{" +
                "id=" + id +
                ", tno='" + tno + '\'' +
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

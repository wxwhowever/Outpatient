package com.entity;

//皮试用药单
public class ASTdrug {
    private int id;

    private String skinno;//编号

    private String patient_pno;//患者编号

    private String doctor_dno;//医师编号

    private String drug_dno;//药品

    private String mmol;//试敏溶液浓度

    private String dosage;//剂量

    private String sum;//合计

    private String remarks;//备注

    private String date;//开单时间

    private String state;

    public ASTdrug() {
    }

    public ASTdrug(String skinno, String patient_pno, String doctor_dno, String drug_dno, String mmol, String dosage, String sum, String remarks, String date, String state) {
        this.skinno = skinno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.mmol = mmol;
        this.dosage = dosage;
        this.sum = sum;
        this.remarks = remarks;
        this.date = date;
        this.state = state;
    }

    public ASTdrug(int id, String skinno, String patient_pno, String doctor_dno, String drug_dno, String mmol, String dosage, String sum, String remarks, String date, String state) {
        this.id = id;
        this.skinno = skinno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.drug_dno = drug_dno;
        this.mmol = mmol;
        this.dosage = dosage;
        this.sum = sum;
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

    public String getSkinno() {
        return skinno;
    }

    public void setSkinno(String skinno) {
        this.skinno = skinno;
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

    public String getMmol() {
        return mmol;
    }

    public void setMmol(String mmol) {
        this.mmol = mmol;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
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

    @Override
    public String toString() {
        return "ASTdrug{" +
                "id=" + id +
                ", skinno='" + skinno + '\'' +
                ", patient_pno='" + patient_pno + '\'' +
                ", doctor_dno='" + doctor_dno + '\'' +
                ", drug_dno='" + drug_dno + '\'' +
                ", mmol='" + mmol + '\'' +
                ", dosage='" + dosage + '\'' +
                ", sum='" + sum + '\'' +
                ", remarks='" + remarks + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

package com.entity;

//治疗单
public class Treat {

    private int id;

    private String tno;//编号

    private Patient patient_pno;//患者

    private Doctor doctor_dno;//医生

    private String startdate;//开始时间

    private String enddate;//结束时间

    private String result;//治疗结果

    private String type;//治疗类型

    public Treat() {
    }

    public Treat(int id, String tno, Patient patient_pno, Doctor doctor_dno, String startdate, String enddate, String result, String type) {
        this.id = id;
        this.tno = tno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.startdate = startdate;
        this.enddate = enddate;
        this.result = result;
        this.type = type;
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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

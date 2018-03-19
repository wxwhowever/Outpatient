package com.entity;

//治疗单
public class Treat {

    private int id;

    private String treatno;//编号

    private String patient_pno;//患者

    private String doctor_dno;//医生

    private String enddate;//结束时间

    private String result;//治疗结果

    private String type;//治疗类型

    private Integer state;

    public Treat() {
    }

    public Treat(int id, String treatno, String patient_pno, String doctor_dno, String enddate, String result, String type, Integer state) {
        this.id = id;
        this.treatno = treatno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.enddate = enddate;
        this.result = result;
        this.type = type;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettreatno() {
        return treatno;
    }

    public void settreatno(String treatno) {
        this.treatno = treatno;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

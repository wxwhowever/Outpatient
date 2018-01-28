package com.entity;

//皮试结果单
public class ASTresult {
    private int id;

    private String resultno;//编号

    private Patient patient_pno;//患者编号

    private Doctor doctor_dno;//皮试操作人

    private String starttime;//开始时间

    private String endtime;//结束时间

    private String result;//皮试结果

    public ASTresult() {
    }

    public ASTresult(int id, String resultno, Patient patient_pno, Doctor doctor_dno, String starttime, String endtime, String result) {
        this.id = id;
        this.resultno = resultno;
        this.patient_pno = patient_pno;
        this.doctor_dno = doctor_dno;
        this.starttime = starttime;
        this.endtime = endtime;
        this.result = result;
    }
}

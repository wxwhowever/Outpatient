package com.entity;

public class Diagnosis_result {
    private int id;
    private String drno;//诊疗结果编号
    private String result;//诊疗结果
    private String again;//第几次就诊
    private Doctor doctor_dno;//诊疗医生
    private Patient patient_pno;//诊疗患者
    private Prescribe prescribe_pno;//开药单
    private ASTdrug asTdrug_skinno;//皮试用药单
    private  ASTresult asTresult_resultno;//皮试结果单
    private Injectdrug injectdrug_ino;//注射用药单
    private Transfusion transfusion_tno;//输液用药单
    private Treat treat_tno;//治疗单
    private String endDate;//诊疗结束时间

    public Diagnosis_result() {
    }

    public Diagnosis_result(int id, String drno, String result, String again, Doctor doctor_dno, Patient patient_pno, Prescribe prescribe_pno, ASTdrug asTdrug_skinno, ASTresult asTresult_resultno, Injectdrug injectdrug_ino, Transfusion transfusion_tno, Treat treat_tno, String endDate) {
        this.id = id;
        this.drno = drno;
        this.result = result;
        this.again = again;
        this.doctor_dno = doctor_dno;
        this.patient_pno = patient_pno;
        this.prescribe_pno = prescribe_pno;
        this.asTdrug_skinno = asTdrug_skinno;
        this.asTresult_resultno = asTresult_resultno;
        this.injectdrug_ino = injectdrug_ino;
        this.transfusion_tno = transfusion_tno;
        this.treat_tno = treat_tno;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrno() {
        return drno;
    }

    public void setDrno(String drno) {
        this.drno = drno;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAgain() {
        return again;
    }

    public void setAgain(String again) {
        this.again = again;
    }

    public Doctor getDoctor_dno() {
        return doctor_dno;
    }

    public void setDoctor_dno(Doctor doctor_dno) {
        this.doctor_dno = doctor_dno;
    }

    public Patient getPatient_pno() {
        return patient_pno;
    }

    public void setPatient_pno(Patient patient_pno) {
        this.patient_pno = patient_pno;
    }

    public Prescribe getPrescribe_pno() {
        return prescribe_pno;
    }

    public void setPrescribe_pno(Prescribe prescribe_pno) {
        this.prescribe_pno = prescribe_pno;
    }

    public ASTdrug getAsTdrug_skinno() {
        return asTdrug_skinno;
    }

    public void setAsTdrug_skinno(ASTdrug asTdrug_skinno) {
        this.asTdrug_skinno = asTdrug_skinno;
    }

    public ASTresult getAsTresult_resultno() {
        return asTresult_resultno;
    }

    public void setAsTresult_resultno(ASTresult asTresult_resultno) {
        this.asTresult_resultno = asTresult_resultno;
    }

    public Injectdrug getInjectdrug_ino() {
        return injectdrug_ino;
    }

    public void setInjectdrug_ino(Injectdrug injectdrug_ino) {
        this.injectdrug_ino = injectdrug_ino;
    }

    public Transfusion getTransfusion_tno() {
        return transfusion_tno;
    }

    public void setTransfusion_tno(Transfusion transfusion_tno) {
        this.transfusion_tno = transfusion_tno;
    }

    public Treat getTreat_tno() {
        return treat_tno;
    }

    public void setTreat_tno(Treat treat_tno) {
        this.treat_tno = treat_tno;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

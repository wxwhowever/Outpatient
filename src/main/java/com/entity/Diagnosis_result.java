package com.entity;

public class Diagnosis_result {
    private int id;
    private String drno;//诊疗结果编号
    private String result;//诊疗结果
    private String again;//第几次就诊
    private String doctor_dno;//诊疗医生
    private String patient_pno;//诊疗患者

    private String  prescribe_pno;//开药单
    private String asTdrug_skinno;//皮试用药单
    private String asTresult_resultno;//皮试结果单
    private String injectdrug_ino;//注射用药单
    private String transfusion_tno;//输液用药单
    private String treat_tno;//治疗单
    private String endDate;//诊疗结束时间

    public Diagnosis_result() {
    }

    public Diagnosis_result(String drno, String result, String again, String doctor_dno, String patient_pno, String prescribe_pno, String asTdrug_skinno, String asTresult_resultno, String injectdrug_ino, String transfusion_tno, String treat_tno, String endDate) {
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

    public Diagnosis_result(int id, String drno, String result, String again, String doctor_dno, String patient_pno, String prescribe_pno, String asTdrug_skinno, String asTresult_resultno, String injectdrug_ino, String transfusion_tno, String treat_tno, String endDate) {
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

    public String getDoctor_dno() {
        return doctor_dno;
    }

    public void setDoctor_dno(String doctor_dno) {
        this.doctor_dno = doctor_dno;
    }

    public String getPatient_pno() {
        return patient_pno;
    }

    public void setPatient_pno(String patient_pno) {
        this.patient_pno = patient_pno;
    }

    public String getPrescribe_pno() {
        return prescribe_pno;
    }

    public void setPrescribe_pno(String prescribe_pno) {
        this.prescribe_pno = prescribe_pno;
    }

    public String getAsTdrug_skinno() {
        return asTdrug_skinno;
    }

    public void setAsTdrug_skinno(String asTdrug_skinno) {
        this.asTdrug_skinno = asTdrug_skinno;
    }

    public String getAsTresult_resultno() {
        return asTresult_resultno;
    }

    public void setAsTresult_resultno(String asTresult_resultno) {
        this.asTresult_resultno = asTresult_resultno;
    }

    public String getInjectdrug_ino() {
        return injectdrug_ino;
    }

    public void setInjectdrug_ino(String injectdrug_ino) {
        this.injectdrug_ino = injectdrug_ino;
    }

    public String getTransfusion_tno() {
        return transfusion_tno;
    }

    public void setTransfusion_tno(String transfusion_tno) {
        this.transfusion_tno = transfusion_tno;
    }

    public String getTreat_tno() {
        return treat_tno;
    }

    public void setTreat_tno(String treat_tno) {
        this.treat_tno = treat_tno;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Diagnosis_result{" +
                "id=" + id +
                ", drno='" + drno + '\'' +
                ", result='" + result + '\'' +
                ", again='" + again + '\'' +
                ", doctor_dno='" + doctor_dno + '\'' +
                ", patient_pno='" + patient_pno + '\'' +
                ", prescribe_pno='" + prescribe_pno + '\'' +
                ", asTdrug_skinno='" + asTdrug_skinno + '\'' +
                ", asTresult_resultno='" + asTresult_resultno + '\'' +
                ", injectdrug_ino='" + injectdrug_ino + '\'' +
                ", transfusion_tno='" + transfusion_tno + '\'' +
                ", treat_tno='" + treat_tno + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

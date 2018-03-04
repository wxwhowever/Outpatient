package com.entity;

import java.util.List;

/**
 * 产科转科表
 * 产科表2222
 */
public class CK_change {

    private int id;
//    候诊编号
    private String CNO;
//    病人编号
    private String pno;
//    姓名
    private String name;
//    转科原因
    private String  remark;
//    记录时间
    private String date;
//    就诊卡卡号
    private String jzno;
//    记录人
    private String dno;

    public CK_change() {
    }

    public CK_change(String CNO, String pno, String name, String remark, String date, String jzno, String dno) {
        this.CNO = CNO;
        this.pno = pno;
        this.name = name;
        this.remark = remark;
        this.date = date;
        this.jzno = jzno;
        this.dno = dno;
    }

    public CK_change(int id, String CNO, String pno, String name, String remark, String date, String jzno, String dno) {
        this.id = id;
        this.CNO = CNO;
        this.pno = pno;
        this.name = name;
        this.remark = remark;
        this.date = date;
        this.jzno = jzno;
        this.dno = dno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getJzno() {
        return jzno;
    }

    public void setJzno(String jzno) {
        this.jzno = jzno;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    @Override
    public String toString() {
        return "CK_change{" +
                "id=" + id +
                ", CNO='" + CNO + '\'' +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", date='" + date + '\'' +
                ", jzno='" + jzno + '\'' +
                ", dno='" + dno + '\'' +
                '}';
    }
}

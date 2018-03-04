package com.entity;

import java.util.List;

/**
 * 产科超额登记表
 */
public class CK_overfulfil {

    private int id;
//    登记编号
    private String ofno;
//    病人编号
    private String pno;
//    姓名
    private String name;
//    候诊时间
    private String date;
//    分诊人
    private String dno;


    public CK_overfulfil() {
    }

    public CK_overfulfil(String ofno, String pno, String name, String date, String dno) {
        this.ofno = ofno;
        this.pno = pno;
        this.name = name;
        this.date = date;
        this.dno = dno;
    }

    public CK_overfulfil(int id, String ofno, String pno, String name, String date, String dno) {
        this.id = id;
        this.ofno = ofno;
        this.pno = pno;
        this.name = name;
        this.date = date;
        this.dno = dno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfno() {
        return ofno;
    }

    public void setOfno(String ofno) {
        this.ofno = ofno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    @Override
    public String toString() {
        return "CK_overfulfil{" +
                "id=" + id +
                ", ofno='" + ofno + '\'' +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", dno='" + dno + '\'' +
                '}';
    }
}

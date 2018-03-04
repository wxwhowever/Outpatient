package com.entity;

import java.util.List;

/**
 * 产科信息记录表
 * sdsads
 */
public class CK_info {

    private int id;
//    产科记录编号
    private String crno;
//    病人编号
    private String pno;
//    姓名
    private String name;
//    身高
    private String height;
//    体重
    private int weight;
//    记录人
    private String dno;
    //    就诊卡卡号
    private String jzno;
    //    记录时间
    private String date;


    public CK_info() {
    }

    public CK_info(String crno, String pno, String name, String height, int weight, String dno, String jzno, String date) {
        this.crno = crno;
        this.pno = pno;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dno = dno;
        this.jzno = jzno;
        this.date = date;
    }

    public CK_info(int id, String crno, String pno, String name, String height, int weight, String dno, String jzno, String date) {
        this.id = id;
        this.crno = crno;
        this.pno = pno;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dno = dno;
        this.jzno = jzno;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrno() {
        return crno;
    }

    public void setCrno(String crno) {
        this.crno = crno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public String getJzno() {
        return jzno;
    }

    public void setJzno(String jzno) {
        this.jzno = jzno;
    }

    @Override
    public String toString() {
        return "CK_info{" +
                "id=" + id +
                ", crno='" + crno + '\'' +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight=" + weight +
                ", dno='" + dno + '\'' +
                ", jzno='" + jzno + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


package com.entity;

import java.util.List;

/**
 * 口腔科候诊表
 */
public class KQ_wait {

    private int id;
//    候诊编号
    private String wno;
//    病人编号
    private String pno;
//    姓名
    private String name;
//    性别
    private String sex;
//    年龄
    private int age;
//    患病类型
    private String  type;
//    患病描述
    private String  remark;
//    患病等级
    private String  level;
//    候诊时间
    private String date;
//    就诊卡卡号
    private String jzno;
//    分诊人
    private String dno;


    public KQ_wait() {
    }

    public KQ_wait(String wno, String pno, String name, String sex, int age, String type, String remark, String level, String date, String jzno, String dno) {
        this.wno = wno;
        this.pno = pno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
        this.level = level;
        this.date = date;
        this.jzno = jzno;
        this.dno = dno;
    }

    public KQ_wait(int id, String wno, String pno, String name, String sex, int age, String type, String remark, String level, String date, String jzno, String dno) {
        this.id = id;
        this.wno = wno;
        this.pno = pno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.remark = remark;
        this.level = level;
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

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        return "KQ_wait{" +
                "id=" + id +
                ", wno='" + wno + '\'' +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", level='" + level + '\'' +
                ", date='" + date + '\'' +
                ", jzno='" + jzno + '\'' +
                ", dno='" + dno + '\'' +
                '}';
    }
}

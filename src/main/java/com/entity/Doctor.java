package com.entity;

/**
 * 医生表
 */
public class Doctor {

    private int id;
//    医生编号
    private String dno;
//    姓名
    private String name;
//    性别
    private String sex;
//
    private int age;
//    职位年龄
    private String  position;
//   科室编号
    private String officeno;

    public Doctor() {
    }

    public Doctor(int id, String dno, String name, String sex, int age, String position, String officeno) {
        this.id = id;
        this.dno = dno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
        this.officeno = officeno;
    }

    public Doctor(String dno, String name, String sex, int age, String position, String officeno) {
        this.dno = dno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
        this.officeno = officeno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOfficeno() {
        return officeno;
    }

    public void setOfficeno(String officeno) {
        this.officeno = officeno;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", dno='" + dno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", officeno='" + officeno + '\'' +
                '}';
    }
}

package com.entity;

public class Doctor {

    private int id;
//    医生编号
    private String DNO;
//    姓名
    private String name;
//    性别
    private String sex;
//    年龄
    private int age;
//    职位
    private String  profession;
//   科室编号
    private String officeno;

    public Doctor() {
    }

    public Doctor(int id, String DNO, String name, String sex, int age, String profession, String officeno) {
        this.id = id;
        this.DNO = DNO;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.officeno = officeno;
    }

    public Doctor(String DNO, String name, String sex, int age, String profession, String officeno) {
        this.DNO = DNO;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.officeno = officeno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNO() {
        return DNO;
    }

    public void setDNO(String DNO) {
        this.DNO = DNO;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
                ", DNO='" + DNO + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", officeno='" + officeno + '\'' +
                '}';
    }
}

package com.entity;

/**
 * 内科门诊表
 */
public class Medicine {

    private int id;
//    科室编号
    private String officeno;
//    姓名
    private String name;
//    性别
    private String sex;
//    年龄
    private int age;
//    职位
    private String  position;


    public Medicine() {
    }

    public Medicine(int id, String officeno, String name, String sex, int age, String position) {
        this.id = id;
        this.officeno = officeno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
    }

    public Medicine(String officeno, String name, String sex, int age, String position) {
        this.officeno = officeno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfficeno() {
        return officeno;
    }

    public void setOfficeno(String officeno) {
        this.officeno = officeno;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", officeno='" + officeno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}

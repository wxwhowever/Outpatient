package com.entity;

import java.util.HashMap;

/**
 * 就诊卡表
 */
public class Medicalcard {

    private int id;
//    就诊卡号
    private String jzno;
//    姓名
    private String name;
//    密码
    private String password;
//    身份证号
    private String card;
//    性别
    private String sex;
//    年龄
    private int age;
//    职业
    private String  profession;
//    地址
    private String address;
//    余额
    private float money;
//    创建时间
    private String createdate;
//    电话
    private String phone;
//    是否预约
    private String subscribe;

//    医保卡
    private String ybno;
//    银医卡
    private String  yyno;

    public Medicalcard() {
    }

    public Medicalcard(int id, String jzno, String name, String password, String card, String sex, int age, String profession, String address, float money, String createdate, String phone, String subscribe, String ybno, String yyno) {
        this.id = id;
        this.jzno = jzno;
        this.name = name;
        this.password = password;
        this.card = card;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.money = money;
        this.createdate = createdate;
        this.phone = phone;
        this.subscribe = subscribe;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public Medicalcard(String jzno, String name, String password, String card, String sex, int age, String profession, String address, float money, String createdate, String phone, String subscribe, String ybno, String yyno) {
        this.jzno = jzno;
        this.name = name;
        this.password = password;
        this.card = card;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.money = money;
        this.createdate = createdate;
        this.phone = phone;
        this.subscribe = subscribe;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public String getYbno() {
        return ybno;
    }

    public void setYbno(String ybno) {
        this.ybno = ybno;
    }

    public String getYyno() {
        return yyno;
    }

    public void setYyno(String yyno) {
        this.yyno = yyno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJzno() {
        return jzno;
    }

    public void setJzno(String jzno) {
        this.jzno = jzno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    @Override
    public String toString() {
        return "Medicalcard{" +
                "id=" + id +
                ", jzno='" + jzno + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", card='" + card + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", createdate='" + createdate + '\'' +
                ", phone='" + phone + '\'' +
                ", subscribe='" + subscribe + '\'' +
                ", ybno='" + ybno + '\'' +
                ", yyno='" + yyno + '\'' +
                '}';
    }
}

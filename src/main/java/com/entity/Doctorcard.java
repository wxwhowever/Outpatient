package com.entity;

// 医保卡
public class Doctorcard {

    private int id;
//    银医卡号
    private String yyno;
//    姓名
    private String name;
//    密码
    private String password;
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

    public Doctorcard() {
    }

    public Doctorcard(String phone,String yyno, String name, String password, String sex, int age, String profession, String address, float money, String createdate) {
        this.yyno = yyno;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.money = money;
        this.createdate = createdate;
        this.phone = phone;
    }

    public Doctorcard(String phone,int id, String yyno, String name, String password, String sex, int age, String profession, String address, float money, String createdate) {
        this.id = id;
        this.yyno = yyno;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.money = money;
        this.createdate = createdate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYyno() {
        return yyno;
    }

    public void setYyno(String yyno) {
        this.yyno = yyno;
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

    @Override
    public String toString() {
        return "Doctorcard{" +
                "id=" + id +
                ", yyno='" + yyno + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", createdate='" + createdate + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

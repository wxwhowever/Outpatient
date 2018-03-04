package com.entity;

/**
 * 挂号表
 */
public class Registration {

    private int id;
//    挂号编号
    private String rsno;
//    姓名
    private String name;
//    身份证号
    private String card;
//    挂号类型
    private String type;
//    性别
    private String sex;
//    年龄
    private int age;
//    职业
    private String  profession;
//    地址
    private String address;
//    电话
    private String phone;
 //    创建时间
    private String createdate;
//    就诊卡
    private String jzno;
//    医保卡
    private String ybno;
//    银医卡
    private String yyno;

    public Registration() {
    }

    public Registration(String rsno, String name, String card, String type, String sex, int age, String profession, String address, String phone, String createdate, String jzno, String ybno, String yyno) {
        this.rsno = rsno;
        this.name = name;
        this.card = card;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
        this.jzno = jzno;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public Registration(int id, String rsno, String name, String card, String type, String sex, int age, String profession, String address, String phone, String createdate, String jzno, String ybno, String yyno) {
        this.id = id;
        this.rsno = rsno;
        this.name = name;
        this.card = card;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
        this.jzno = jzno;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRsno() {
        return rsno;
    }

    public void setRsno(String rsno) {
        this.rsno = rsno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getYbno() {
        return ybno;
    }

    public void setYbno(String ybno) {
        this.ybno = ybno;
    }

    public String getJzno() {
        return jzno;
    }

    public void setJzno(String jzno) {
        this.jzno = jzno;
    }

    public String getYyno() {
        return yyno;
    }

    public void setYyno(String yyno) {
        this.yyno = yyno;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", rsno='" + rsno + '\'' +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdate='" + createdate + '\'' +
                ", jzno='" + jzno + '\'' +
                ", ybno='" + ybno + '\'' +
                ", yyno='" + yyno + '\'' +
                '}';
    }
}

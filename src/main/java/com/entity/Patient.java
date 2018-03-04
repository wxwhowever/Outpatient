package com.entity;


/**
 * 病人表
 */
public class Patient{

    private int id;
//    病人编号
    private String pno;
//    患者姓名
    private String name;
//    身份证号
    private String card;
//    患病类型
    private String type;
//    患病描述
    private String remark;
//    性别
    private String sex;
//    年龄
    private int age;
//    职业
    private String  profession;
//    地址
    private String address;
//    病案时间
    private String createdate;
//    电话
    private String phone;
//    挂号编号
    private String rsno;
//    就诊卡
    private String jzno;
//    医保卡
    private String ybno;
//    银医卡
    private String yyno;

    public Patient() {
    }

    public Patient(int id, String pno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, String rsno, String jzno, String ybno, String yyno) {
        this.id = id;
        this.pno = pno;
        this.name = name;
        this.card = card;
        this.type = type;
        this.remark = remark;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.createdate = createdate;
        this.phone = phone;
        this.rsno = rsno;
        this.jzno = jzno;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public Patient(String pno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, String rsno, String jzno, String ybno, String yyno) {
        this.pno = pno;
        this.name = name;
        this.card = card;
        this.type = type;
        this.remark = remark;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.createdate = createdate;
        this.phone = phone;
        this.rsno = rsno;
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

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getRsno() {
        return rsno;
    }

    public void setRsno(String rsno) {
        this.rsno = rsno;
    }

    public String getJzno() {
        return jzno;
    }

    public void setJzno(String jzno) {
        this.jzno = jzno;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", pno='" + pno + '\'' +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", createdate='" + createdate + '\'' +
                ", phone='" + phone + '\'' +
                ", rsno='" + rsno + '\'' +
                ", jzno='" + jzno + '\'' +
                ", ybno='" + ybno + '\'' +
                ", yyno='" + yyno + '\'' +
                '}';
    }
}

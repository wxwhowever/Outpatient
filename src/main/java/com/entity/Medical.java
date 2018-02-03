package com.entity;


/**
 * 病案表
 */
public class Medical {

    private int id;
//    病案编号
    private String mcno;
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
//    就诊卡
    private Medicalcard medicalcard;
//    医保卡
    private Medicarecard medicarecard;

    public Medical() {
    }

    public Medical(int id, String mcno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Medicalcard medicalcard, Medicarecard medicarecard) {
        this.id = id;
        this.mcno = mcno;
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
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
    }

    public Medical(String mcno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Medicalcard medicalcard, Medicarecard medicarecard) {
        this.mcno = mcno;
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
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMcno() {
        return mcno;
    }

    public void setMcno(String mcno) {
        this.mcno = mcno;
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

    public Medicalcard getMedicalcard() {
        return medicalcard;
    }

    public void setMedicalcard(Medicalcard medicalcard) {
        this.medicalcard = medicalcard;
    }

    public Medicarecard getMedicarecard() {
        return medicarecard;
    }

    public void setMedicarecard(Medicarecard medicarecard) {
        this.medicarecard = medicarecard;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "id=" + id +
                ", mcno='" + mcno + '\'' +
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
                ", medicalcard=" + medicalcard +
                ", medicarecard=" + medicarecard +
                '}';
    }
}

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
    private Registration registration;
//    就诊卡
    private Medicalcard medicalcard;
//    医保卡
    private Medicarecard medicarecard;
//    银医卡
    private Doctorcard doctorcard;

    public Patient() {
    }

    public Patient(String pno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Registration registration, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {
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
        this.registration = registration;
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
        this.doctorcard = doctorcard;
    }

    public Patient(int id, String pno, String name, String card, String type, String remark, String sex, int age, String profession, String address, String createdate, String phone, Registration registration, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {

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
        this.registration = registration;
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
        this.doctorcard = doctorcard;
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

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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

    public Doctorcard getDoctorcard() {
        return doctorcard;
    }

    public void setDoctorcard(Doctorcard doctorcard) {
        this.doctorcard = doctorcard;
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
                ", registration=" + registration +
                ", medicalcard=" + medicalcard +
                ", medicarecard=" + medicarecard +
                ", doctorcard=" + doctorcard +
                '}';
    }
}

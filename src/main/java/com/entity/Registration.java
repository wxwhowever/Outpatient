package com.entity;

public class Registration {

    private int id;
//    挂号编号
    private String RSNO;
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
    private Medicalcard medicalcard;
//    医保卡
    private Medicarecard medicarecard;
//    银医卡
    private Doctorcard doctorcard;

    public Registration() {
    }

    public Registration(String RSNO, String name, String card, String type, String sex, int age, String profession, String address, String phone, String createdate, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {
        this.RSNO = RSNO;
        this.name = name;
        this.card = card;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
        this.medicalcard = medicalcard;
        this.medicarecard = medicarecard;
        this.doctorcard = doctorcard;
    }

    public Registration(int id, String RSNO, String name, String card, String type, String sex, int age, String profession, String address, String phone, String createdate, Medicalcard medicalcard, Medicarecard medicarecard, Doctorcard doctorcard) {
        this.id = id;
        this.RSNO = RSNO;
        this.name = name;
        this.card = card;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
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

    public String getRSNO() {
        return RSNO;
    }

    public void setJRSNO(String RSNO) {
        this.RSNO = RSNO;
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
        return "Registration{" +
                "id=" + id +
                ", RSNO='" + RSNO + '\'' +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdate='" + createdate + '\'' +
                ", medicalcard=" + medicalcard +
                ", medicarecard=" + medicarecard +
                ", doctorcard=" + doctorcard +
                '}';
    }
}

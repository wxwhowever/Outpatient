package com.entity;

/**
 * 分诊表
 */
public class Triage {

    private int id;
//    挂号编号
    private String tno;
//    姓名
    private String name;
//    挂号类型
    private String type;
//    性别
    private String sex;
//    年龄
    private int age;
//    电话
    private String phone;
 //    创建时间
    private String createdate;
//    分诊状态 0,未分诊 1，已分诊
    private int state;
//    挂号编号
    private String rsno;
//    就诊卡
    private String jzno;
//    医保卡
    private String ybno;
//    银医卡
    private String yyno;

    public Triage() {
    }

    public Triage( String tno, String name, String type, String sex, int age, String phone, String createdate, int state, String rsno, String jzno, String ybno, String yyno) {
        this.tno = tno;
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.createdate = createdate;
        this.state = state;
        this.rsno = rsno;
        this.jzno = jzno;
        this.ybno = ybno;
        this.yyno = yyno;
    }

    public Triage(int id, String tno, String name, String type, String sex, int age, String phone, String createdate, int state, String rsno, String jzno, String ybno, String yyno) {
        this.id = id;
        this.tno = tno;
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.createdate = createdate;
        this.state = state;
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

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        return "Triage{" +
                "id=" + id +
                ", tno='" + tno + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", createdate='" + createdate + '\'' +
                ", state=" + state +
                ", rsno='" + rsno + '\'' +
                ", jzno='" + jzno + '\'' +
                ", ybno='" + ybno + '\'' +
                ", yyno='" + yyno + '\'' +
                '}';
    }
}

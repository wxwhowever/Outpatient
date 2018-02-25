package com.entity;

public class Drug {
    //药品ID
    private int drug_id;
    //药品编号
    private String drug_dno;
    //药品名称
    private String drug_name;
    //药品类型
    private String drug_type;
    //药品价格
    private double drug_price;
    //药品规格
    private String drug_spec;
    //使用方法
    private String drug_use;
    //药品用量
    private String drug_dosage;
    //药品库房
    private Bank bank_id;
    //药品有效日期
    private String drug_time;

    public Drug() {
    }

    public Drug(int drug_id, String drug_dno, String drug_name, String drug_type, double drug_price, String drug_spec, String drug_use, String drug_dosage, Bank bank_id, String drug_time) {
        this.drug_id = drug_id;
        this.drug_dno = drug_dno;
        this.drug_name = drug_name;
        this.drug_type = drug_type;
        this.drug_price = drug_price;
        this.drug_spec = drug_spec;
        this.drug_use = drug_use;
        this.drug_dosage = drug_dosage;
        this.bank_id = bank_id;
        this.drug_time = drug_time;
    }

    public int getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(String drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type;
    }

    public double getDrug_price() {
        return drug_price;
    }

    public void setDrug_price(double drug_price) {
        this.drug_price = drug_price;
    }

    public String getDrug_spec() {
        return drug_spec;
    }

    public void setDrug_spec(String drug_spec) {
        this.drug_spec = drug_spec;
    }

    public String getDrug_use() {
        return drug_use;
    }

    public void setDrug_use(String drug_use) {
        this.drug_use = drug_use;
    }

    public String getDrug_dosage() {
        return drug_dosage;
    }

    public void setDrug_dosage(String drug_dosage) {
        this.drug_dosage = drug_dosage;
    }

    public Bank getBank_id() {
        return bank_id;
    }

    public void setBank_id(Bank bank_id) {
        this.bank_id = bank_id;
    }

    public String getDrug_time() {
        return drug_time;
    }

    public void setDrug_time(String drug_time) {
        this.drug_time = drug_time;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drug_id=" + drug_id +
                ", drug_dno='" + drug_dno + '\'' +
                ", drug_name='" + drug_name + '\'' +
                ", drug_type='" + drug_type + '\'' +
                ", drug_price=" + drug_price +
                ", drug_spec='" + drug_spec + '\'' +
                ", drug_use='" + drug_use + '\'' +
                ", drug_dosage='" + drug_dosage + '\'' +
                ", bank_id=" + bank_id +
                ", drug_time='" + drug_time + '\'' +
                '}';
    }
}

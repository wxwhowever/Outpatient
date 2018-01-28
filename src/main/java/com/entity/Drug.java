package com.entity;

public class Drug {
    //id
    private int drug_id;
    //药品编号
    private int drug_dno;
    //药品名称
    private String drug_name;
    //药品类型
    private Drugtype drug_type;
    //药品价格
    private double drug_price;
    //现有数量
    private int drug_repertory;
    //药品描述
    private String drug_describe;
    //药品有效日期
    private String drug_time;

    public Drug() {
    }

    public Drug(int drug_id, int drug_dno, String drug_name, Drugtype drug_type, double drug_price, int drug_repertory, String drug_describe, String drug_time) {
        this.drug_id = drug_id;
        this.drug_dno = drug_dno;
        this.drug_name = drug_name;
        this.drug_type = drug_type;
        this.drug_price = drug_price;
        this.drug_repertory = drug_repertory;
        this.drug_describe = drug_describe;
        this.drug_time = drug_time;
    }

    public int getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public int getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(int drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public Drugtype getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(Drugtype drug_type) {
        this.drug_type = drug_type;
    }

    public double getDrug_price() {
        return drug_price;
    }

    public void setDrug_price(double drug_price) {
        this.drug_price = drug_price;
    }

    public int getDrug_repertory() {
        return drug_repertory;
    }

    public void setDrug_repertory(int drug_repertory) {
        this.drug_repertory = drug_repertory;
    }

    public String getDrug_describe() {
        return drug_describe;
    }

    public void setDrug_describe(String drug_describe) {
        this.drug_describe = drug_describe;
    }

    public String getDrug_time() {
        return drug_time;
    }

    public void setDrug_time(String drug_time) {
        this.drug_time = drug_time;
    }
}

package com.entity;

public class Buy {
    //id
    private int buy_id;
    //剂型
    private String  buy_jx;
    //规格
    private String buy_spec;
    //生厂厂商
    private String buy_firm;
    //供货单位
    private String buy_supplier;
    //药品名称
    private Drug drug_name;
    //数量
    private int buy_count;
    //价格
    private double buy_price;
    //购进日期
    private String buy_time;
    //接收人
    private String buy_signer;

    public Buy() {
    }

    public Buy(int buy_id, String buy_jx, String buy_spec, String buy_firm, String buy_supplier, Drug drug_name, int buy_count, double buy_price, String buy_time, String buy_signer) {
        this.buy_id = buy_id;
        this.buy_jx = buy_jx;
        this.buy_spec = buy_spec;
        this.buy_firm = buy_firm;
        this.buy_supplier = buy_supplier;
        this.drug_name = drug_name;
        this.buy_count = buy_count;
        this.buy_price = buy_price;
        this.buy_time = buy_time;
        this.buy_signer = buy_signer;
    }

    public int getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(int buy_id) {
        this.buy_id = buy_id;
    }

    public String getBuy_jx() {
        return buy_jx;
    }

    public void setBuy_jx(String buy_jx) {
        this.buy_jx = buy_jx;
    }

    public String getBuy_spec() {
        return buy_spec;
    }

    public void setBuy_spec(String buy_spec) {
        this.buy_spec = buy_spec;
    }

    public String getBuy_firm() {
        return buy_firm;
    }

    public void setBuy_firm(String buy_firm) {
        this.buy_firm = buy_firm;
    }

    public String getBuy_supplier() {
        return buy_supplier;
    }

    public void setBuy_supplier(String buy_supplier) {
        this.buy_supplier = buy_supplier;
    }

    public Drug getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(Drug drug_name) {
        this.drug_name = drug_name;
    }

    public int getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(int buy_count) {
        this.buy_count = buy_count;
    }

    public double getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    public String getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(String buy_time) {
        this.buy_time = buy_time;
    }

    public String getBuy_signer() {
        return buy_signer;
    }

    public void setBuy_signer(String buy_signer) {
        this.buy_signer = buy_signer;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buy_id=" + buy_id +
                ", buy_jx='" + buy_jx + '\'' +
                ", buy_spec='" + buy_spec + '\'' +
                ", buy_firm='" + buy_firm + '\'' +
                ", buy_supplier='" + buy_supplier + '\'' +
                ", drug_name=" + drug_name +
                ", buy_count=" + buy_count +
                ", buy_price=" + buy_price +
                ", buy_time='" + buy_time + '\'' +
                ", buy_signer='" + buy_signer + '\'' +
                '}';
    }
}

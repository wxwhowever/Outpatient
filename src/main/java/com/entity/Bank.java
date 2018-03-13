package com.entity;

public class Bank {
    //库房ID
    private int bank_id;
    //库房存药类型
    private int drug_type;
    //库房数量
    private int bank_count;

    public Bank() {
    }

    public Bank(int bank_id, int drug_type, int bank_count) {
        this.bank_id = bank_id;
        this.drug_type = drug_type;
        this.bank_count = bank_count;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public int getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(int drug_type) {
        this.drug_type = drug_type;
    }

    public int getBank_count() {
        return bank_count;
    }

    public void setBank_count(int bank_count) {
        this.bank_count = bank_count;
    }
}

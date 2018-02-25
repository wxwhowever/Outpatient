package com.entity;

public class Bank {
    //库房ID
    private int bank_id;
    //库房存药类型
    private Drugtype type_id;
    //库房数量
    private int bank_count;

    public Bank() {
    }

    public Bank(int bank_id, Drugtype type_id, int bank_count) {
        this.bank_id = bank_id;
        this.type_id = type_id;
        this.bank_count = bank_count;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public Drugtype getType_id() {
        return type_id;
    }

    public void setType_id(Drugtype type_id) {
        this.type_id = type_id;
    }

    public int getBank_count() {
        return bank_count;
    }

    public void setBank_count(int bank_count) {
        this.bank_count = bank_count;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank_id=" + bank_id +
                ", type_id=" + type_id +
                ", bank_count=" + bank_count +
                '}';
    }
}

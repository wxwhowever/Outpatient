package com.entity;

public class Recede {
    //id
    private int redece_id;
    //退药id
    private Drug drug_dno;
    //退药时间
    private String recede_time;
    //退药原因
    private String recede_cause;
    //退药病人
    private String recede_person;
    //授理护士
    private String redece_nurse;
    //退药数量
    private String redece_count;
    //退药金额
    private String recede_price;

    public Recede() {
    }

    public Recede(int redece_id, Drug drug_dno, String recede_time, String recede_cause, String recede_person, String redece_nurse, String redece_count, String recede_price) {
        this.redece_id = redece_id;
        this.drug_dno = drug_dno;
        this.recede_time = recede_time;
        this.recede_cause = recede_cause;
        this.recede_person = recede_person;
        this.redece_nurse = redece_nurse;
        this.redece_count = redece_count;
        this.recede_price = recede_price;
    }

    public int getRedece_id() {
        return redece_id;
    }

    public void setRedece_id(int redece_id) {
        this.redece_id = redece_id;
    }

    public Drug getDrug_dno() {
        return drug_dno;
    }

    public void setDrug_dno(Drug drug_dno) {
        this.drug_dno = drug_dno;
    }

    public String getRecede_time() {
        return recede_time;
    }

    public void setRecede_time(String recede_time) {
        this.recede_time = recede_time;
    }

    public String getRecede_cause() {
        return recede_cause;
    }

    public void setRecede_cause(String recede_cause) {
        this.recede_cause = recede_cause;
    }

    public String getRecede_person() {
        return recede_person;
    }

    public void setRecede_person(String recede_person) {
        this.recede_person = recede_person;
    }

    public String getRedece_nurse() {
        return redece_nurse;
    }

    public void setRedece_nurse(String redece_nurse) {
        this.redece_nurse = redece_nurse;
    }

    public String getRedece_count() {
        return redece_count;
    }

    public void setRedece_count(String redece_count) {
        this.redece_count = redece_count;
    }

    public String getRecede_price() {
        return recede_price;
    }

    public void setRecede_price(String recede_price) {
        this.recede_price = recede_price;
    }

    @Override
    public String toString() {
        return "Recede{" +
                "redece_id=" + redece_id +
                ", drug_dno=" + drug_dno +
                ", recede_time='" + recede_time + '\'' +
                ", recede_cause='" + recede_cause + '\'' +
                ", recede_person='" + recede_person + '\'' +
                ", redece_nurse='" + redece_nurse + '\'' +
                ", redece_count='" + redece_count + '\'' +
                ", recede_price='" + recede_price + '\'' +
                '}';
    }
}

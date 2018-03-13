package com.entity;

public class DrugType {
    //类型ID
    private int type_id;
    //类型名称
    private String type_name;
    //父ID
    private int type_tid;

    public DrugType() {
    }

    public DrugType(int type_id, String type_name, int type_tid) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_tid = type_tid;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getType_tid() {
        return type_tid;
    }

    public void setType_tid(int type_tid) {
        this.type_tid = type_tid;
    }

    @Override
    public String toString() {
        return "DrugType{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                ", type_tid=" + type_tid +
                '}';
    }
}

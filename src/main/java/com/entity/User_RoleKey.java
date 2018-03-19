package com.entity;

public class User_RoleKey {
    private Integer uid;

    private Integer rid;

    public User_RoleKey(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public User_RoleKey() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", rid=").append(rid);
        sb.append("]");
        return sb.toString();
    }
}
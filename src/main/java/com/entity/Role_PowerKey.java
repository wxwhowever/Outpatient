package com.entity;

public class Role_PowerKey {
    private Integer rid;

    private Integer pid;

    public Role_PowerKey(Integer rid, Integer pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public Role_PowerKey() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }
}
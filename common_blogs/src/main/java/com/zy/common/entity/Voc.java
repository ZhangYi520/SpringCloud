package com.zy.common.entity;

import lombok.Data;

@Data
public class Voc {
    private String uuid;

    private String pid;

    private String vocCode;

    private String level;

    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getVocCode() {
        return vocCode;
    }
}
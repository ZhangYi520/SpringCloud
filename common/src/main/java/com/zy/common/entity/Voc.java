package com.zy.common.entity;

public class Voc {
    private String uuid;

    private String pid;

    private String vocCode;

    private String vocNameLev1;

    private String vocNameLev2;

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

    public void setVocCode(String vocCode) {
        this.vocCode = vocCode == null ? null : vocCode.trim();
    }

    public String getVocNameLev1() {
        return vocNameLev1;
    }

    public void setVocNameLev1(String vocNameLev1) {
        this.vocNameLev1 = vocNameLev1 == null ? null : vocNameLev1.trim();
    }

    public String getVocNameLev2() {
        return vocNameLev2;
    }

    public void setVocNameLev2(String vocNameLev2) {
        this.vocNameLev2 = vocNameLev2 == null ? null : vocNameLev2.trim();
    }
}
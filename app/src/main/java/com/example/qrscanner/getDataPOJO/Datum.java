package com.example.qrscanner.getDataPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("RegNo")
    @Expose
    private String regNo;
    @SerializedName("FormNo")
    @Expose
    private String formNo;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Age")
    @Expose
    private String age;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Ref")
    @Expose
    private String ref;
    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("Bar")
    @Expose
    private String bar;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Aadhar")
    @Expose
    private String aadhar;
    @SerializedName("seva")
    @Expose
    private String seva;
    @SerializedName("groupp")
    @Expose
    private String groupp;
    @SerializedName("remark")
    @Expose
    private String remark;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getSeva() {
        return seva;
    }

    public void setSeva(String seva) {
        this.seva = seva;
    }

    public String getGroupp() {
        return groupp;
    }

    public void setGroupp(String groupp) {
        this.groupp = groupp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

package com.bben.lookboard.bean;

import java.util.List;

public class BeadInfoBean  {

    int bedNo;
    String name;
    String sex;
    String cureNo;
    String age;
    String buyType;
    String  hospitalDate;
    String doctorName;
    List<NurseLevel>  NurseLevel;
    String Level;
    int  levelType;


    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public int getLevelType() {
        return levelType;
    }

    public void setLevelType(int levelType) {
        this.levelType = levelType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCureNo() {
        return cureNo;
    }

    public void setCureNo(String cureNo) {
        this.cureNo = cureNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public String getHospitalDate() {
        return hospitalDate;
    }

    public void setHospitalDate(String hospitalDate) {
        this.hospitalDate = hospitalDate;
    }

    public List<BeadInfoBean.NurseLevel> getNurseLevel() {
        return NurseLevel;
    }

    public void setNurseLevel(List<BeadInfoBean.NurseLevel> NurseLevel) {
        this.NurseLevel = NurseLevel;
    }

    public static class NurseLevel {

        String dev;

        public String getDev() {
            return dev;
        }

        public void setDev(String dev) {
            this.dev = dev;
        }

    }
}

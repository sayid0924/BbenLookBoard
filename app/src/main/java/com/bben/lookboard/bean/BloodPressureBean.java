package com.bben.lookboard.bean;

import java.util.List;

public class BloodPressureBean {

    String title;
    String countNo;
    List<BloodPressureChildren> bloodPressureChildren;


   public static class  BloodPressureChildren{
        String beadNo;

        public String getBeadNo() {
            return beadNo;
        }

        public void setBeadNo(String beadNo) {
            this.beadNo = beadNo;
        }
    }

    public String getCountNo() {
        return countNo;
    }

    public void setCountNo(String countNo) {
        this.countNo = countNo;
    }

    public List<BloodPressureChildren> getBloodPressureChildren() {
        return bloodPressureChildren;
    }

    public void setBloodPressureChildren(List<BloodPressureChildren> bloodPressureChildren) {
        this.bloodPressureChildren = bloodPressureChildren;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

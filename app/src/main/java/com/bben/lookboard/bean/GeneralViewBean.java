package com.bben.lookboard.bean;

import java.util.List;

public class GeneralViewBean {

    String title;
    String countNo;

    List< GeneralViewBeanChildren> generalViewBeanChildren;

    public  static  class  GeneralViewBeanChildren{
        String beadNo;
        public String getBeadNo() {
            return beadNo;
        }

        public void setBeadNo(String beadNo) {
            this.beadNo = beadNo;
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountNo() {
        return countNo;
    }

    public void setCountNo(String countNo) {
        this.countNo = countNo;
    }

    public List<GeneralViewBeanChildren> getGeneralViewBeanChildren() {
        return generalViewBeanChildren;
    }

    public void setGeneralViewBeanChildren(List<GeneralViewBeanChildren> generalViewBeanChildren) {
        this.generalViewBeanChildren = generalViewBeanChildren;
    }
}

package com.bben.lookboard.bean;

public class NurseSchedulBean {


    String name;
    String title;

    public NurseSchedulBean(String title,String name) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

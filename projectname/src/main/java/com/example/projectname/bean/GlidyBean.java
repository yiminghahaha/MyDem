package com.example.projectname.bean;

import java.io.Serializable;

public class GlidyBean implements Serializable {
    private  String title;
    private  Boolean mselected;

    @Override
    public String toString() {
        return "GlidyBean{" +
                "title='" + title + '\'' +
                ", mselected=" + mselected +
                '}';
    }

    public GlidyBean() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getMselected() {
        return mselected;
    }

    public void setMselected(Boolean mselected) {
        this.mselected = mselected;
    }

    public GlidyBean(String title, Boolean mselected) {

        this.title = title;
        this.mselected = mselected;
    }
}

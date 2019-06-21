package com.example.myfragmentmanager;

public class Studen {
    private  String name;
    private  Boolean aa = true;
    private  Boolean bb = false;

    @Override
    public String toString() {
        return "Studen{" +
                "name='" + name + '\'' +
                ", aa=" + aa +
                ", bb=" + bb +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAa() {
        return aa;
    }

    public void setAa(Boolean aa) {
        this.aa = aa;
    }

    public Boolean getBb() {
        return bb;
    }

    public void setBb(Boolean bb) {
        this.bb = bb;
    }

    public Studen() {
        super();
    }

    public Studen(String name, Boolean aa, Boolean bb) {
        this.name = name;
        this.aa = aa;
        this.bb = bb;
    }
}

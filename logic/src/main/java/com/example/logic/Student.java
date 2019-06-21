package com.example.logic;

public class Student {
    private  Boolean aBoolean ;
    private  String name;

    @Override
    public String toString() {
        return "Student{" +
                "aBoolean=" + aBoolean +
                ", name='" + name + '\'' +
                '}';
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {

    }

    public Student(Boolean aBoolean, String name) {
        this.aBoolean = aBoolean;
        this.name = name;
    }
}

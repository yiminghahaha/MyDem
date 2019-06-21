package com.example.appdemo1;

public class Car {
    private  String name;
    private  String sex;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
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

    public Car() {
        super();
    }

    public Car(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}

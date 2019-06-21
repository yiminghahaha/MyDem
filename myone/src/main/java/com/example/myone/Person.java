package com.example.myone;

public class Person {
    private  String name;
    private  Boolean a = false;
    private  Boolean b = false;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public Person() {

    }

    public Person(String name, Boolean a, Boolean b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }
}

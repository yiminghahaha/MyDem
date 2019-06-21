package com.example.myview;

public class Student {
    private  Boolean a = true;
    private  Boolean b = false;

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "a=" + a +
                ", b=" + b +
                '}';
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

    public Student(Boolean a, Boolean b) {

        this.a = a;
        this.b = b;
    }
}

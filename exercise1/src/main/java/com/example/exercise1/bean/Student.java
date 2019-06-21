package com.example.exercise1.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private  Long id;

    @Property
    private  String title;

    @Property
    private  boolean aBoolean;

    @Generated(hash = 1975631465)
    public Student(Long id, String title, boolean aBoolean) {
        this.id = id;
        this.title = title;
        this.aBoolean = aBoolean;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getABoolean() {
        return this.aBoolean;
    }

    public void setABoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", aBoolean=" + aBoolean +
                '}';
    }
}

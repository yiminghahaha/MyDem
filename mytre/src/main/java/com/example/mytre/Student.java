package com.example.mytre;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private  Long id;

    @Property
    private  String image;

    @Property
    private  String name;

    @Property
    private  Boolean aBoolean;

    @Generated(hash = 1118511283)
    public Student(Long id, String image, String name, Boolean aBoolean) {
        this.id = id;
        this.image = image;
        this.name = name;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getABoolean() {
        return this.aBoolean;
    }

    public void setABoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", aBoolean=" + aBoolean +
                '}';
    }
}

package com.example.mywork;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DataBean {
    @Id(autoincrement = true)
    private  Long id;

    @Property
    private  String title;

    @Property
    private  Boolean aBoolean;

    @Generated(hash = 541673708)
    public DataBean(Long id, String title, Boolean aBoolean) {
        this.id = id;
        this.title = title;
        this.aBoolean = aBoolean;
    }

    @Generated(hash = 908697775)
    public DataBean() {
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

    public Boolean getABoolean() {
        return this.aBoolean;
    }

    public void setABoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", aBoolean=" + aBoolean +
                '}';
    }
}

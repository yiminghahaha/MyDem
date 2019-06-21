package com.example.myworkone.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Dao_bean {
    @Id(autoincrement = true)
    private  Long id;

    @Property
    private  String url;

    @Property
    private  String title;

    @Generated(hash = 1243469288)
    public Dao_bean(Long id, String url, String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }

    @Generated(hash = 478185806)
    public Dao_bean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Dao_bean{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

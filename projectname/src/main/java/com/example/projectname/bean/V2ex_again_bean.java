package com.example.projectname.bean;

public class V2ex_again_bean {
    private  String src;
    private  String text;
    private  String count;
    private  String name;

    @Override
    public String toString() {
        return "V2ex_again_bean{" +
                "src='" + src + '\'' +
                ", text='" + text + '\'' +
                ", count='" + count + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public V2ex_again_bean() {
        super();
    }

    public V2ex_again_bean(String src, String text, String count, String name) {
        this.src = src;
        this.text = text;
        this.count = count;
        this.name = name;
    }
}

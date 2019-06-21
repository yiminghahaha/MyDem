package com.example.projectname.bean;

public class V2ex_tab {
    private  String tab;
    private  String url;

    @Override
    public String toString() {
        return "V2ex_tab{" +
                "tab='" + tab + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public V2ex_tab() {
        super();
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public V2ex_tab(String tab, String url) {

        this.tab = tab;
        this.url = url;
    }
}

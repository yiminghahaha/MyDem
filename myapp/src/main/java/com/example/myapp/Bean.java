package com.example.myapp;

public class Bean {
    private  String image;
    private  String name;
    private  String price;

    public Bean() {

    }

    @Override
    public String toString() {
        return "Bean{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Bean(String image, String name, String price) {

        this.image = image;
        this.name = name;
        this.price = price;
    }
}

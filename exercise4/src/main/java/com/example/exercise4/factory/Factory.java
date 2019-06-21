package com.example.exercise4.factory;

import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

public class Factory {
    public Computer setshape(String shapetype){
        if (shapetype==null){
            return null;
        }
        if (shapetype.equalsIgnoreCase("Rectangle")){
            return  new Rectangle();
        }else if (shapetype.equalsIgnoreCase("Square")){
            return new Square();
        }else if (shapetype.equalsIgnoreCase("circle")){
            return  new Circle();
        }
        return null;

    }
}

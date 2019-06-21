package com.example.projectname;

import com.example.projectname.bean.V2ex_tab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Text1 {



    public static void main(String[] args) {
        ArrayList<V2ex_tab> v2ex_tabs = new ArrayList<>();
        try {
            Document document = Jsoup.connect("https://www.v2ex.com/").get();
            Elements select = document.select("div#Tabs > a");
            if (select!=null){
                for (int i = 0; i < select.size(); i++) {
                    Element element = select.get(i);
                    String tab = element.text();
                    String href = element.attr("href");
                    System.out.println(tab);
                    System.out.println(href);
                    v2ex_tabs.add(new V2ex_tab(tab,href));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.projectname.medol;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.V2ex_tab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class V2ex_Medol extends BaseMedol{

    public void getdata(final BaseCallback<ArrayList<V2ex_tab>> baseCallback) {
       new Thread(){
           @Override
           public void run() {
               ArrayList<V2ex_tab> v2ex_tabs = new ArrayList<>();
               try {
                   Document document = Jsoup.connect("https://www.v2ex.com/").get();
                   Elements select = document.select("div#Tabs > a");
                   if (select!=null){
                       for (int i = 0; i < select.size(); i++) {
                           Element element = select.get(i);
                           String tab = element.text();
                           String href = element.attr("href");
                           v2ex_tabs.add(new V2ex_tab(tab,href));
                       }
                       if (v2ex_tabs!=null){
                           baseCallback.seccuss(v2ex_tabs);
                       }else {
                           baseCallback.filed("空");
                       }
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }.start();

    }
}

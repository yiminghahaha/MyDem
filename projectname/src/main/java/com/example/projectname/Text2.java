package com.example.projectname;

import com.example.projectname.bean.V2ex_again_bean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Text2 {
    public static void main(String[] args){
        try {
            ArrayList<V2ex_again_bean> list = new ArrayList<>();
            V2ex_again_bean againBean = new V2ex_again_bean();
            Document document = Jsoup.connect("https://www.v2ex.com/?tab=tech").get();
            Elements elements = document.select("div.cell.item");
            for (Element ele:elements){
                Elements image = ele.select("table tr td a img.avatar");
                //取图片
                if (image!=null){
                    String src = image.attr("src");
                    System.out.println(src);
                    againBean.setSrc(src);
                }

                //取文本
                Elements select = ele.select("table tr td span.item_title a");
                if (select!=null){
                    String text = select.get(0).text();
                    System.out.println(text);
                    againBean.setText(text);
                }

                //评论次数
                Elements select1 = ele.select("table tr td a.count_livid");
                if (select1.size()>0){
                    String count = select1.get(0).text();
                    System.out.println(count);
                    againBean.setCount(count);
                }

                //取作者
                Elements elements1 = ele.select("table tr td span.topic_info strong a");
                if (elements1!=null){
                    String name = elements1.get(0).text();
                    System.out.println(name);
                    againBean.setName(name);
                }
                list.add(againBean);
                System.out.println(list.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

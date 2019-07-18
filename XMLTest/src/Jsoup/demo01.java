package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * **********************************************************
 *
 * @Project: jsoup测试解析test.xml
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-18 09:05
 * @description:
 ************************************************************/
public class demo01 {


    public static void main(String[] args) {
        //文件放在根目录下
        String path = demo01.class.getClassLoader().getResource("test.xml").getPath();

        try {
            Document document = Jsoup.parse(new File(path), "utf-8");
            Elements elements = document.getElementsByTag("test");

            System.out.println(elements);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}

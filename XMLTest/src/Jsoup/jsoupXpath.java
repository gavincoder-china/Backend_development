package Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project: 使用jsoupxpath方法来读取document
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-18 11:27
 * @description:  https://github.com/zhegexiaohuozi/JsoupXpath.git
 ************************************************************/
public class jsoupXpath {

    public static void main(String[] args) {
        String path = jsoupXpath.class.getClassLoader().getResource("test.xml").getPath();

        Document document = null;
        try {
            document = Jsoup.parse(new File(path), "utf-8");
            JXDocument jxDocument = new JXDocument(document);


            //xpath的语法
            List<JXNode> jxNodes = jxDocument.selN("//name");
            for (JXNode jxNode : jxNodes) {
                System.out.println(jxNode);
            }
            System.out.println("---------------------");
            List<JXNode> jxNodes2 = jxDocument.selN("//name[@id='gg']");
            for (JXNode jxNode : jxNodes2) {
                System.out.println(jxNode);

            }


        }
        catch (IOException | XpathSyntaxErrorException e) {
            e.printStackTrace();
        }


    }


}

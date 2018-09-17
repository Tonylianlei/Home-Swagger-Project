package com.example.demo.configpool.builder.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 创建人:连磊
 * 日期: 2018/9/12. 10:08
 * 描述：XML解析
 */
public class XMLAnalysis {

    public static void getNodeInfo(String xmlPath) throws DocumentException {
        //读取XML文件，获得document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(xmlPath));
        Element rootElement = document.getRootElement();
        Element element = rootElement.element("context");
        Element sqlMapGenerator = element.element("sqlMapGenerator");
        Attribute targetPackage = sqlMapGenerator.attribute("targetPackage");
        Attribute targetProject = sqlMapGenerator.attribute("targetProject");
        String mapperPath = System.getProperty("user.dir") + "\\"+targetProject.getValue() + "\\" + targetPackage.getValue().replace("." , "\\");
        List<Element> tableElements = element.elements("table");
        for (Element tableElement : tableElements){
            File file = new File(mapperPath+"\\"+tableElement.attribute("domainObjectName").getValue()+"mapper.xml");
            if (file.exists()){
                file.delete();
            }
        }
    }
}

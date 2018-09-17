package com.example.demo.configpool.builder.comment;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Properties;

public class MyCommentGenerator implements CommentGenerator {


    @Override
    public void addConfigurationProperties(Properties properties) {

    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !"".equals(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("@ApiModelProperty(value = \"" + introspectedColumn.getRemarks() + "\")");
        }
    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {


    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModelProperty;");
        topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModel;");
        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.Data"));

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * "+introspectedTable.getRemarks());
        topLevelClass.addJavaDocLine(" */");
        topLevelClass.addJavaDocLine("@Data");
        topLevelClass.addJavaDocLine("@ApiModel(description = \""+introspectedTable.getRemarks()+"\")");
    }


    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }


    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
    }


    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }


    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }


    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }


    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }


    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }


    @Override
    public void addComment(XmlElement xmlElement) {
    }


    @Override
    public void addRootComment(XmlElement rootElement) {

    }

}

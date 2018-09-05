package com.example.demo.configPool.builder.field;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;


public class FieldsPlugin extends PluginAdapter {
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addFields(topLevelClass, introspectedTable, "fields");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
   
	@Override
	public boolean sqlMapBaseColumnListElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		XmlElement isNullElement = new XmlElement("if");
		isNullElement.addAttribute(new Attribute("test", "fields == null"));
		element.getElements().forEach(isNullElement::addElement);
		element.getElements().clear();
		element.addElement(isNullElement);
		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "fields != null"));
		isNotNullElement.addElement(new TextElement(
		      "${fields}"));
		element.addElement(isNotNullElement);
		return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
	}

	private void addFields(TopLevelClass topLevelClass,
                           IntrospectedTable introspectedTable, String name) {
    	CommentGenerator commentGenerator = context.getCommentGenerator();
    	Field field = new Field();
    	field.setVisibility(JavaVisibility.PROTECTED);
    	field.setType(PrimitiveTypeWrapper.getStringInstance());
    	field.setName(name);
    	commentGenerator.addFieldComment(field, introspectedTable);
    	topLevelClass.addField(field);
    	char c = name.charAt(0);
    	String camel = Character.toUpperCase(c) + name.substring(1);
    	Method method = new Method();
    	method.setVisibility(JavaVisibility.PUBLIC);
    	method.setName("set" + camel);
    	method.addParameter(new Parameter(PrimitiveTypeWrapper.getStringInstance(), name));
    	method.addBodyLine("this." + name + "=" + name + ";");
    	commentGenerator.addGeneralMethodComment(method, introspectedTable);
    	topLevelClass.addMethod(method);
    	method = new Method();
    	method.setVisibility(JavaVisibility.PUBLIC);
    	method.setReturnType(PrimitiveTypeWrapper.getStringInstance());
    	method.setName("get" + camel);
    	method.addBodyLine("return " + name + ";");
    	commentGenerator.addGeneralMethodComment(method, introspectedTable);
    	topLevelClass.addMethod(method);
    }
	


	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		
		List<Element> elements = element.getElements();
		
		StringBuilder columns = new StringBuilder();
		
		List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
		
		
		for (IntrospectedColumn introspectedColumn : allColumns) {
			
			columns.append(",").append(introspectedColumn.getActualColumnName());
		}
		columns.deleteCharAt(0);
		elements.set(1, new TextElement(columns.toString()));
		
		
		return super.sqlMapSelectByPrimaryKeyElementGenerated(element,
				introspectedTable);
	}

	/**
     * This plugin is always valid - no properties are required
     */
	@Override
	public boolean validate(List<String> warnings) {
		return true;
    }


	@Override
	public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              Plugin.ModelClassType modelClassType) {
		return false;
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              Plugin.ModelClassType modelClassType) {
		return false;
	}
}
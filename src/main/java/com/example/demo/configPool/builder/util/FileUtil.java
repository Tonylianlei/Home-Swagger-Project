package com.example.demo.configPool.builder.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class FileUtil {
	/**
	 * 获取resource下面配置文件
	 * @param path
	 * @return
	 */
	public  String getResourceFilePathByName(String path)
	{
		String realPath = null;
		ClassLoader classLoader = getClass().getClassLoader();  
		if(null != path &&!"".equals(path))
		{
			realPath = classLoader.getResource(path).getFile();
		}
		return realPath;
	}
	
	/**
	 * 获取jar 包下resource下面配置文件
	 * @param path
	 * @return
	 */
	public  String getJarResourceFilePathByName(String path)
	{
		String realPath = null;
		ClassLoader classLoader = getClass().getClassLoader();  
		if(null != path &&!"".equals(path))
		{
			try {
				realPath = IOUtils.toString(classLoader.getResourceAsStream(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return realPath;
	}
	
	/**
	 * 根据path获取当前目录路径
	 * @return
	 */
	public String getCurrentPath(String path) {
		String currentPath = null;
		if(null != path &&!"".equals(path))
		{
			currentPath = getClass().getResource(path).getFile().toString();
		}
		return currentPath;
	}
	
}

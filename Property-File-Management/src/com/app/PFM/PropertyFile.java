package com.app.PFM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	private static PropertyFile configurablePropertyFile = null;

	public static PropertyFile getConfigurableInstance() {
		if (null == configurablePropertyFile) {
			configurablePropertyFile = new PropertyFile("configurableFile.properties");
		}
		return configurablePropertyFile;
	}

	private Properties objProp = null;

	public String getProp(String argStrPropertyName) {
		return (objProp.getProperty(argStrPropertyName));
	}
	
	public void addorChangeProp(String propertyName, String propertyValue) {
		try{
			FileInputStream in = new FileInputStream("configurableFile.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();
			props.setProperty(propertyName, propertyValue);
			FileOutputStream out = new FileOutputStream("configurableFile.properties");
			props.store(out, null);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			configurablePropertyFile = new PropertyFile("configurableFile.properties");
		}
	}

	private PropertyFile(String fileName) {
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			objProp = new Properties();
			objProp.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

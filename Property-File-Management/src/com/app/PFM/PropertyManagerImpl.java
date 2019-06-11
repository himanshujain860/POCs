package com.app.PFM;

import java.util.Properties;

public class PropertyManagerImpl {
	
	private Properties properties;

	public PropertyManagerImpl() {
		properties = new Properties();
	}
	
	public void addProperty(String propertyName, String propertyValue) {
		properties.put(propertyName, propertyValue);
	}

	public Properties getPropertyfile() {
		return properties;
	}
}

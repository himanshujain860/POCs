package com.app.PFM;

public class Test {

	public static void main(String[] args) {
		System.out.println(PropertyFile.getConfigurableInstance().getProp("Country"));
		PropertyFile.getConfigurableInstance().addorChangeProp("Language", "Hindi");
		System.out.println(PropertyFile.getConfigurableInstance().getProp("Language"));
		System.out.println(PropertyFile.getConfigurableInstance().getProp("Country"));
	}

}

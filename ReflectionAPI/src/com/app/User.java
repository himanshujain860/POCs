package com.app;
/**
 * Class used to define common method
 * @author h.g.jain
 *
 */
public class User {
	
    public void display(Parameter parameter) {
    	System.out.println("user says hello "+parameter.getValue());
    }
    
    public static void staticAction(){
    	System.out.println("Action done with static method");
    }
}

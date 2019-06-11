package com.app;
/**
 * Class used to define common method
 * @author h.g.jain
 *
 */
public class User2 {  
	
    public void display(Parameter parameter, String userName) {
    	System.out.println("user2 says hello "+userName +"with "+parameter.getValue());
    }
    
    public void act(){
    	System.out.println("Action Performed");
    }
}

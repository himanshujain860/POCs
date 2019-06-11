package com.app.java8.MR;

public class Output {
	
	public Output(){
		System.out.println("I am a constructor");
	}

	public static void printOutput(){
		System.out.println("I am a non parametric static method");
	}
	
	public static void printOutput(String obj){
		System.out.println("I am a parametric static method with parameter "+obj);
	}
	
	public void printOutput(Integer x){
		System.out.println("I am a parametric non static method with parameter "+x.toString());
	}
}

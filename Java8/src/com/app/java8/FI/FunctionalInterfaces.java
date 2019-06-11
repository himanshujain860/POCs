package com.app.java8.FI;

@FunctionalInterface
interface sampleFunctionalInterface{
	//Abstract Method
	public void doFunction();
	//Other methods from Object Class
	int hashCode();
	String toString();
	boolean equals(Object obj); 
}

@FunctionalInterface
interface otherFunctionalInterface{
	public void doOtherFunction();
}

interface nonFunctionalInterface{
	default void doIt(){
		System.out.println("I am default method of NON FUNCTIONAL INTERFACE");
	}
}

@FunctionalInterface
interface validFunctionalInterface extends nonFunctionalInterface{
	public void doValidFunction();
}

// Below Interface is not valid as functional interface can't have mulitple functions
//@FunctionalInterface
interface inValidFunctionalInterface extends otherFunctionalInterface{
	public void doInValidFunction();
}

package com.app.java8.LE;

public class ImplementationVersions {
	
	public static void main(String[] args) {
				
		lambdaImpl lambdaImpl = new lambdaImpl();
		lambdaImpl.foo();
		
		lambda lambdaInterface = new lambda(){
			public void foo(){
				System.out.println("Inline implementation of interface");
			}
		};
		lambdaInterface.foo();
		
		lambda lambda = () -> System.out.println("inside Lambda function");
		lambda.foo();
	}

}

interface lambda{
	public void foo();
}

class lambdaImpl implements lambda{
	@Override
	public void foo(){
		System.out.println("Inside Class Implementation");
	}
}
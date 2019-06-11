package com.app.java8.DM;

public class DefaultMethod {

	public static void main(String[] args) {
		One one = new Three();
		one.print();
		One four = new Four();
		four.print();
	}
}

interface One{
	default void print(){
		System.out.println("Interface one is called");
	}
}

interface Two{
	default void print(){
		System.out.println("Interface two is called");
	}
}

class Three implements One, Two{
	public void print(){
		One.super.print();
		Two.super.print();
		System.out.println("Class three is called");
	}
}

class Four implements One{
	public void print(){
		One.super.print();
		System.out.println("Class Four is called.");
	}
}
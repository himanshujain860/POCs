package com.app.java8.MR;

import java.util.function.Consumer;

public class MethodReference {

	public static void main(String[] args) {
		
		Thread constructorThread = new Thread(Output :: new);
		constructorThread.start();

		Thread thread = new Thread(Output :: printOutput);
		thread.start();
		
		Consumer<String> consumer = Output :: printOutput;
		consumer.accept("AMAR");
		
		Consumer<Integer> instanceConsumer = new Output() :: printOutput;
		instanceConsumer.accept(new Integer(23));		
	}
}

package com.app.java8.LE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Examples {

	public static void main(String[] args) {
		threadaExample();
		collectionExample();
	}
	
	public static void threadaExample(){
		Thread myThread = new Thread(new Runnable(){
			
			@Override
			public void run(){
				System.out.println("Inside Thread through Runnable");
			}
		});
		myThread.start();
		
		Thread lambdaThread = new Thread(() -> System.out.println("Inside Thread through Lambda"));
		lambdaThread.start();
	}
	
	public static void collectionExample(){
		List<String> names1 = new ArrayList<String>();
		names1.add("Adam");
		names1.add("Virat");
		names1.add("Suresh");
		names1.add("Dinesh");
		names1.add("Mahendra");
		List<String> names2 = new ArrayList<String>();
		names2.addAll(names1);
		
		System.out.println("Using Java7");
		Collections.sort(names1, new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	         }
	      });
		for(String name : names1){
			System.out.println(name);
		}
		
		System.out.println("Using Java8");
		Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
		for(String name : names2){
			System.out.println(name);
		}
	}
}

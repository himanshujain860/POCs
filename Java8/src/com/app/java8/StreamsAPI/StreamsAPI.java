package com.app.java8.StreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsAPI {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//Distinct
		getDistinctElements(numbers);
		System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
		//Filter
		getNoOfEmptyStrings(strings);
		System.out.println(strings.stream().filter(string->string.isEmpty()).count());
		//Filter and collect
		getNonEmptyStrings(strings);
		System.out.println(strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList()));
		getSingleString(strings);
		System.out.println(strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", ")));
		//Map
		getSquares(numbers);
		System.out.println(numbers.stream().map( i ->i/3).collect(Collectors.toList()));
		//Summary Statistics
		System.out.println(numbers.stream().mapToInt((x) ->x).summaryStatistics());
	}
	
	private static void getDistinctElements(List<Integer> numbers){
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(numbers);
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println(list);
	}
	
	private static void getSquares(List<Integer> numbers){
		List<Integer> squares = new ArrayList<>();
		for (Integer integer : numbers) {
			squares.add(integer/3);
		}
		System.out.println(squares);
	}

	private static void getNoOfEmptyStrings(List<String> strings){
		int count=0;
		for (String string : strings) {
			if(string.isEmpty()){
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void getNonEmptyStrings(List<String> strings){
		List<String> nonEmptyStrings = new ArrayList<String>();
		for (String string : strings) {
			if(!string.isEmpty()){
				nonEmptyStrings.add(string);
			}
		}
		System.out.println(nonEmptyStrings);
	}
	
	private static void getSingleString(List<String> strings){
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			if(!string.isEmpty()){
				stringBuilder.append(string+", ");
			}
		}
		System.out.println(stringBuilder.toString());
	}
}

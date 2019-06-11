package com.pms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CollectionPOC {
	
	public static void main(String[] args) {
		String a = "1, 2, 3, 4";
		a = a.replaceAll(" ", "");
		String b = "3, 4, 5, 6";
		b = b.replaceAll(" ", "");
		List<String> aList = new ArrayList<String>();
		aList.addAll(Arrays.asList(a.split(Pattern.quote(","))));
		List<String> bList = new ArrayList<String>();
		bList.addAll(Arrays.asList(b.split(Pattern.quote(","))));
		aList.removeAll(bList);
		System.out.println("A-B  "+aList);
		aList = new ArrayList<String>();
		aList.addAll(Arrays.asList(a.split(Pattern.quote(","))));
		bList = new ArrayList<String>();
		bList.addAll(Arrays.asList(b.split(Pattern.quote(","))));
		bList.removeAll(aList);
		System.out.println("B-A  "+bList);
		aList = new ArrayList<String>();
		aList.addAll(Arrays.asList(a.split(Pattern.quote(","))));
		bList = new ArrayList<String>();
		bList.addAll(Arrays.asList(b.split(Pattern.quote(","))));
		Set<String> testSet = new HashSet<String>();
		testSet.addAll(aList);
		testSet.addAll(bList);
		System.out.println("AUB  "+testSet);
		aList = new ArrayList<String>();
		aList.addAll(Arrays.asList(a.split(Pattern.quote(","))));
		bList = new ArrayList<String>();
		bList.addAll(Arrays.asList(b.split(Pattern.quote(","))));
		testSet = new HashSet<String>();
		testSet.addAll(aList);
		testSet.retainAll(bList);
		System.out.println("AIB  "+testSet);

	}
}

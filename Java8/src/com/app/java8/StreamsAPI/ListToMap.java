package com.app.java8.StreamsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
	
	public static void main(String[] args) {
		Plan();
		DuplicateKey();
		SortedMap();
	}

	public static void SortedMap() {
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity(1, "FIRST"));
		entities.add(new Entity(3, "THIRD"));
		entities.add(new Entity(2, "SECOND"));
		entities.add(new Entity(5, "FIFTH"));
		entities.add(new Entity(4, "FOURTH"));
		Map<Integer,String> map = entities.stream()
				.sorted(Comparator.comparingInt(Entity :: getId).reversed())
				.collect(
				Collectors.toMap(Entity :: getId, Entity :: getName, (oldKey, newKey)->newKey, LinkedHashMap :: new));
		System.out.println(map);
	}
	public static void DuplicateKey() {
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity(1, "FIRST"));
		entities.add(new Entity(3, "THIRD"));
		entities.add(new Entity(2, "SECOND"));
		entities.add(new Entity(5, "FIFTH"));
		entities.add(new Entity(4, "SECOND"));
		Map<String, Integer> map = entities.stream().collect(
				Collectors.toMap(Entity :: getName,Entity :: getId, (oldKey, newKey)->newKey));
		System.out.println(map);
	}
	
	public static void Plan() {
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity(1, "FIRST"));
		entities.add(new Entity(3, "THIRD"));
		entities.add(new Entity(2, "SECOND"));
		entities.add(new Entity(5, "FIFTH"));
		entities.add(new Entity(4, "FOURTH"));
		Map<String, Integer> map = entities.stream().collect(
				Collectors.toMap(Entity :: getName,Entity :: getId));
		System.out.println(map);
	}
}

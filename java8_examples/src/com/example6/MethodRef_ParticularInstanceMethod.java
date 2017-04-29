package com.example6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MethodRef_ParticularInstanceMethod {
	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("David");
		names.add("Richard");
		names.add("Samuel");
		names.add("Rose");
		names.add("John");

		MethodRef_ParticularInstanceMethod.printNames(names, System.out::println);
		MethodRef_ParticularInstanceMethod.printNames(names, x -> System.out.println(x));
		
	}

	private static void printNames(List<String> list, Consumer<String> c) {
		list.forEach(x -> c.accept(x));
	}

}

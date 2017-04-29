package com.example6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodRef_Construtor {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(4, 9, 16, 25, 36);
		List<Double> squaredNumbers = MethodRef_Construtor.findSquareRoot(numbers, Double::new);
		System.out.println("Square root of numbers = " + squaredNumbers);

		List<Double> squaredNumbers1 = MethodRef_Construtor.findSquareRoot(numbers, (i) -> new Double(i));
		System.out.println("Square root of numbers = " + squaredNumbers1);

	}

	private static List<Double> findSquareRoot(List<Integer> list, Function<Integer, Double> f) {
		List<Double> result = new ArrayList<Double>();
		list.forEach(x -> result.add(Math.sqrt(f.apply(x))));
		return result;
	}
}

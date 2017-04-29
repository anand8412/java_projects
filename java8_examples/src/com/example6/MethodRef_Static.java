package com.example6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MethodRef_Static {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
		List<Integer> primeNumbers = MethodRef_Static.findPrimeNumbers(numbers,
				(number) -> MethodRef_Static.isPrime(number));
		System.out.println("Prime Numbers are " + primeNumbers);

		List<Integer> primeNumbers1 = MethodRef_Static.findPrimeNumbers(numbers, MethodRef_Static::isPrime);
		System.out.println("Prime Numbers are " + primeNumbers1);

	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> findPrimeNumbers(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> sortedNumbers = new ArrayList<Integer>();
		list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {sortedNumbers.add(i);});
		return sortedNumbers;
		
		

	}
	
	
}


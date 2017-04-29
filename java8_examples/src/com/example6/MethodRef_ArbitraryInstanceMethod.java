package com.example6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRef_ArbitraryInstanceMethod {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Albert", 80));
		persons.add(new Person("Ben", 15));
		persons.add(new Person("Charlote", 20));
		persons.add(new Person("Dean", 6));
		persons.add(new Person("Elaine", 17));
		

		 
        List<Integer> allAges = MethodRef_ArbitraryInstanceMethod.listAllAges(persons, (p)->p.getAge());
        System.out.println("Printing out all ages \n"+allAges);
        

        List<Integer> allAges1 = MethodRef_ArbitraryInstanceMethod.listAllAges(persons, Person::getAge);
        System.out.println("Printing out all ages \n"+allAges1);

	}

	private static List<Integer> listAllAges(List<Person> person, Function<Person, Integer> f) {
		List<Integer> result = new ArrayList<Integer>();
		person.forEach(x -> result.add(f.apply((Person) x)));
		return result;
	}
}

class Person {

	private final String name;
	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
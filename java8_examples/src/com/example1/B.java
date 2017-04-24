package com.example1;

import java.util.ArrayList;
import java.util.List;

public class B {
	public static void main(String[] args) {

		System.out.println(findEmps(EmployeeProvider.getEmpData(), new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				if (t.getDesignation().equals("umpire"))
					return true;
				return false;
			}
		}));

		System.out.println(findEmps(EmployeeProvider.getEmpData(), new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				if (t.getDesignation().equals("bowler"))
					return true;
				return false;
			}
		}));

	}

	private static List<Employee> findEmps(List<Employee> emps, MyPredicate<Employee> predicate) {
		List<Employee> matchingEmps = new ArrayList<>();
		for (Employee emp : emps) {
			if (predicate.test(emp)) {
				matchingEmps.add(emp);
			}
		}
		return matchingEmps;
	}
}

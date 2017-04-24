package com.example1;

import java.util.ArrayList;
import java.util.List;

public class C {

	public static void main(String[] args) {
		System.out.println(
				findEmployee(EmployeeProvider.getEmpData(), emp -> emp.getDesignation().equals("umpire")));
		System.out.println(
				findEmployee(EmployeeProvider.getEmpData(), emp -> emp.getDesignation().equals("bowler")));
	}

	private static List<Employee> findEmployee(List<Employee> emps, MyPredicate<Employee> predicate) {
		List<Employee> matchingEmps = new ArrayList<>();
		for (Employee emp : emps) {
			if (predicate.test(emp)) {
				matchingEmps.add(emp);
			}
		}
		return matchingEmps;
	}
}

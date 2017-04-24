package com.example1;

import java.util.ArrayList;
import java.util.List;

public class A {

	public static void main(String[] args) {
		System.out.println(findUmpireEmployees(EmployeeProvider.getEmpData()));
		System.out.println(findBowlerEmployees(EmployeeProvider.getEmpData()));
	}
	private static List<Employee> findUmpireEmployees(List<Employee> emps) {

		List<Employee> matchingEmps = new ArrayList<>();
		for (Employee emp : emps) {

			if (emp.getDesignation().equals("umpire")) {
				matchingEmps.add(emp);
			}
		}
		return matchingEmps;

	}
	
	private static List<Employee> findBowlerEmployees(List<Employee> emps) {

		List<Employee> matchingEmps = new ArrayList<>();
		for (Employee emp : emps) {

			if (emp.getDesignation().equals("bowler")) {
				matchingEmps.add(emp);
			}
		}
		return matchingEmps;

	}
}

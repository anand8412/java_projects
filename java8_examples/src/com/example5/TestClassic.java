package com.example5;

import java.util.Collections;
import java.util.List;

public class TestClassic {
public static void main(String[] args) {
	System.out.println("Before sorting");
	System.out.println(EmployeeProvider.getEmpData());
	
	System.out.println("after sorting");
	List<Employee> emps = EmployeeProvider.getEmpData();
	Collections.sort(emps);
	System.out.println(emps);
}
}

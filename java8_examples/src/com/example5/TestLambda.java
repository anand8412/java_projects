package com.example5;

import java.util.Collections;
import java.util.List;

public class TestLambda {
public static void main(String[] args) {
	
	System.out.println("Before sorting");
	System.out.println(EmployeeProvider.getEmpData());
	
	System.out.println("after sorting");
	List<Employee> emps = EmployeeProvider.getEmpData();
	emps.sort((Employee e1,Employee e2) -> {return e1.getFirstName().compareTo(e2.getFirstName());});
	System.out.println(emps);
	Collections.sort(emps,(Employee e1,Employee e2) -> {return e1.getFirstName().compareTo(e2.getFirstName());});
	System.out.println(emps);
}

}

package com.example5;

import java.util.Arrays;
import java.util.List;

public class EmployeeProvider {

	public static List<Employee> getEmpData() {
		Employee e1 = new Employee("sachin", "tendulkar", "batsman", "male", "43");
		Employee e2 = new Employee("billy", "bowden", "umpire", "male", "67");
		Employee e3 = new Employee("venkatesh", "prasad", "bowler", "male", "25");
		Employee e4 = new Employee("javagal", "srinath", "bowler", "male", "23");
		Employee e5 = new Employee("virat", "kohli", "batsman", "male", "12");
		Employee e6 = new Employee("steve", "jobs", "umpire", "male", "21");
		return Arrays.asList(e1, e2, e3, e4, e5, e6);
	}

}

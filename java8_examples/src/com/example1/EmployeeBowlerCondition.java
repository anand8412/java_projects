package com.example1;

public class EmployeeBowlerCondition implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getDesignation().equals("bowler");
	}

}

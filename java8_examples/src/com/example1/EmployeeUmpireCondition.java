package com.example1;

public class EmployeeUmpireCondition implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getDesignation().equals("umpire");
	}

}

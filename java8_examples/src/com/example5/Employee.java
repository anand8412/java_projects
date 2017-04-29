package com.example5;

public class Employee implements Comparable<Employee>{
	public Employee(String firstName, String lastName, String designation, String gender, String age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.gender = gender;
		this.age = age;
	}

	private String firstName;
	private String lastName;
	private String designation;
	private String gender;
	private String age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", designation=" + designation
				+ ", gender=" + gender + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.firstName.compareTo(o.getFirstName());
	}

}

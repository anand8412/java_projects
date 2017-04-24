package com.example2;

public class TestDefaultClass implements Interface1,Interface2{

	@Override
	public void method1(String str) {}
	@Override
	public void method2(String str) {}
	
	@Override
	 public void print(String str){
		System.out.println("testdefaultclass printing..." + str);
	}
	
	
}

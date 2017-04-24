package com.example2;

public interface Interface1 {

	void method1(String str);
	
	default void print(String str){
		System.out.println("Interface1 printing..." + str);
	}
	
}

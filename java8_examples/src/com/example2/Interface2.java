package com.example2;

public interface Interface2 {
	void method2(String str);
	
	default void print(String str){
		System.out.println("Interface2 printing..." + str);
	}
}

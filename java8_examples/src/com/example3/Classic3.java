package com.example3;

public class Classic3 {
public static void main(String[] args) {
	Thread thread1 = new Thread(new Runnable() {
	    @Override
	    public void run(){
	        System.out.println("Task #1 is running");
	    }
	});
	 
	thread1.start();
}
}

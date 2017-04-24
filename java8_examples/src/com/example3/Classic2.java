package com.example3;

public class Classic2 {
public static void main(String[] args) {
	Runnable task1 = new Runnable(){
		 
	    @Override
	    public void run(){
	        System.out.println("Task #1 is running");
	    }
	};
	 
	 
	Thread thread1 = new Thread(task1);
	thread1.start();
}
}

package com.example3;

public class Classic1 {
public static void main(String[] args) {
 

	Thread thread1 = new Thread(new Foo());
	thread1.start();
}
}

class Foo implements Runnable{
	  @Override
	    public void run(){
	        System.out.println("Task #1 is running");
	    }	
}

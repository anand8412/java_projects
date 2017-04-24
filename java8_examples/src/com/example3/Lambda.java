package com.example3;

public class Lambda {
public static void main(String[] args) {
	Runnable task2 = () -> { System.out.println("Task #2 is running"); };
	// start the thread
	new Thread(task2).start();


}
}

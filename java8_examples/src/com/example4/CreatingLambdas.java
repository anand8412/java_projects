package com.example4;

public class CreatingLambdas {

	interface Greeting {
		public String sayHello(String g);
	}

	public void testGreeting(String a, Greeting g) {
		String result = g.sayHello(a);
		System.out.println("Result" + result);
	}

	public static void main(String[] args) {
		
		new CreatingLambdas().testGreeting("anand", (String s) -> {return "Hello, " + s;});
		
		//parenthesis is not mamdatory if there is only one parameter and you shoul dnot mention datatype
		new CreatingLambdas().testGreeting("anand",  s -> "Hello, " + s);
		
		new CreatingLambdas().testGreeting("", (String p) -> !p.isEmpty() ? "Hello, " + p : "Did you miss something");

	}
}
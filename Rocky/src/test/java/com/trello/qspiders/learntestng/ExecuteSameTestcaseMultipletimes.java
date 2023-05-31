
	package com.trello.qspiders.learntestng;

	import org.testng.annotations.Test;

	public class ExecuteSameTestcaseMultipletimes
	//@Test annotation will accept more than one argument
	//invocationCount will accept int as a value and default value is 1
	//this argument will helps in running the same test case for multiple times.
	{	@Test
		public void grapes() {
		System.out.println("grapes");
		}
		@Test(priority = 5)
		public void mango() {
			System.out.println("mango");
		}
		@Test(invocationCount = 3)
		public void banana() {
			System.out.println("banana");
		}
		@Test(priority = 3,invocationCount = 3)
		public void apple() {
			System.out.println("Apple");
		}
		@Test
		public void watermellon() {
			System.out.println("watermellon");
		}

	}
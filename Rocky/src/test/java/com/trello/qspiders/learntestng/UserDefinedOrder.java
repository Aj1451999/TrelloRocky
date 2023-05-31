package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;
//priority is the @Test argument
//priority will help us to run the script in user defined order
//priority will accept the int value
//priority will ignore the defined value if it is -ve or zero
//By default it will be in the alphabetic order
public class UserDefinedOrder 
{	@Test(priority = 2)
	public void grapes() {
	System.out.println("grapes");
	}
	@Test(priority = 4)
	public void mango() {
		System.out.println("mango");
	}
	@Test(priority = 1)
	public void banana() {
		System.out.println("banana");
	}
	@Test(priority = 3)
	public void apple() {
		System.out.println("Apple");
	}
	@Test(priority = 5)
	public void watermellon() {
		System.out.println("watermellon");
	}

}

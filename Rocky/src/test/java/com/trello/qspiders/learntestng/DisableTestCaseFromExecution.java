package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class DisableTestCaseFromExecution 
//A particular test can be mutes from the execution
//by calling the argument called enabled.
//enable argument is by default true and it will accept the boolean value

{
	@Test(priority = 2, invocationCount = 3)
	public void mangoTest() {
		System.out.println("mangoTest");
	}

	@Test(priority = 6,enabled = false)
	public void appleTest() {
		System.out.println("appleTest");
	}

	@Test(priority = 5)
	public void orangeTest() {
		System.out.println("orangeTest");
	}

	@Test(priority = 3)
	public void bananaTest() {
		System.out.println("bananaTest");
	}

	@Test(priority = 4)
	public void grapesTest() {
		System.out.println("grapesTest");
	}

	@Test(priority = 1)
	public void watermelonTest() {
		System.out.println("watermelon Test");
	}
}

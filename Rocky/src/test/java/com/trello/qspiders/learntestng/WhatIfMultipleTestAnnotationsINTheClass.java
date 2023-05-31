package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class WhatIfMultipleTestAnnotationsINTheClass {
	//Test Annotation can be used for any no of times in the given class upon tests
	// By default it will make the test execute in the alphabetic order
	// upon each test/method we can call @Test only for once. 
	// 
	@Test
	public void apple() {
		System.out.println("Apple");
	}
	@Test
	public void mango() {
		System.out.println("mango");
	}
	@Test
	public void banana() {
		System.out.println("banana");
	}
	@Test
	public void grapes() {
		System.out.println("grapes");
	}
	@Test
	public void watermellon() {
		System.out.println("watermellon");
	}

}

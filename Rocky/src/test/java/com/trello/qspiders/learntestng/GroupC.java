package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class GroupC 
{
	@Test(groups = {"adhoc"})
	public void nameG() {
		System.out.println("nameG");
	}
	@Test(groups = {"functional","accessability"})
	public void nameH() {
		System.out.println("nameH");
	}@Test(groups = {"reliability","globalization"})
	public void nameI() {
		System.out.println("NameI");
	}
}

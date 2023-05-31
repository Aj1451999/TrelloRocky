package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class Group {
	@Test(groups = { "adhoc", "regression"})
	public void nameA() {
		System.out.println("nameA");
	}
	@Test(groups = {"functional","integration" })
	public void nameB() {
		System.out.println("nameB");
	}
	@Test(groups = {"smoke", "usability"})
	public void nameC() {
		System.out.println("nameC");
	}

}

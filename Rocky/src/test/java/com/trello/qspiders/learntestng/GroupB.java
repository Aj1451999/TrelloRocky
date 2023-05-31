package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class GroupB {
		@Test(groups = {"adhoc","performance"})
		public void nameD() {
			System.out.println("nameD");
		}
		@Test(groups = {"system","acceptance"})
		public void nameE() {
			System.out.println("nameE");
		}@Test(groups = {"compatability","smoke"})
		public void nameF() {
			System.out.println("NameF");
		}
	}


package com.trello.qspiders.learntestng;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class OrderOfBasicAnnotations {
		@BeforeMethod
		public void login() {
			System.out.println("login");
		}
		@AfterMethod
		public void logout() {
			System.out.println("logout");
		}
		@BeforeTest
		public void configBeforetest() {
			System.out.println("configBeforetest");
		}
		@BeforeClass
		public void signIn() {
			System.out.println("signIn");	
		}
		@Test
		public void uploadProfilePic() {
			System.out.println("uploadProfilePic");
		}

		@Test(dependsOnMethods = "uploadProfilePic")
		public void sendFriendRequest() {
			System.out.println("sendFriendRequest");
			
		}

		@Test(dependsOnMethods = "sendFriendRequest")
		public void acceptFriendRequest() {
			System.out.println("acceptFriendRequest");
		}

	}

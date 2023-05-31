package com.trello.qspiders.learntestng;

	import org.testng.annotations.DataProvider;

	public class DataProviderClass {
		@DataProvider
		public Object dataStorageInDiffClass() {
			
			Object[][] obj = new Object[4][4];

			obj[0][0] = "java";
			obj[0][1] = "Bangalore";
			obj[0][2] = "4";
			obj[0][3] = "123456789";

			obj[1][0] = "selenium";
			obj[1][1] = "Bangalore";
			obj[1][2] = "24";
			obj[1][3] = "098765432";

			obj[2][0] = "sql";
			obj[2][1] = "Bangalore";
			obj[2][2] = "3";
			obj[2][3] = "96379123456";

			obj[3][0] = "manual";
			obj[3][1] = "Bangalore";
			obj[3][2] = "4";
			obj[3][3] = "789963852741";
			return obj;
			

		}
	}

package applicationTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.Util;

class TestingApplication {

//	// if email format valid on create account page
//	@Test
//	void test1IsValidEmailFormat() {
//		assertEquals(true, Util.isValidEmailFormat("richard@empyre.co"));
//	}
//
//	@Test
//	void test2IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat(" "));
//	}
//
//	@Test
//	void test3IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat("richard"));
//	}
//
//	@Test
//	void test4IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat("richard@empyreco"));
//	}
//
//	@Test
//	void test5IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat("richard@"));
//	}
//
//	@Test
//	void test6IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat("richardempyre.co"));
//	}
//
//	@Test
//	void test7IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat(null));
//	}
//
//	@Test
//	void test8IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat(""));
//	}
//
//	@Test
//	void test9IsValidEmailFormat() {
//		assertEquals(false, Util.isValidEmailFormat("***@??.##"));
//	}
//
//	// valid input on create account page
//	@Test
//	void testValidInputOnCreateAccountPage() {
//		assertEquals("Create successful!", Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", "123", "123"));
//	}
//
//	// empty field exists on create account page
//	@Test
//	void test1EmptyFieldExistOnCreateAccountPage() {
//		assertEquals("Please fill in all the fields!",
//				Util.createAccountValidateData("", "aaa", "aaa@sina.com", "123", "123"));
//	}
//
//	@Test
//	void test2EmptyFieldExistOnCreateAccountPage() {
//		assertEquals("Please fill in all the fields!",
//				Util.createAccountValidateData("aaa", "", "aaa@sina.com", "123", "123"));
//	}
//
//	@Test
//	void test3EmptyFieldExistOnCreateAccountPage() {
//		assertEquals("Please fill in all the fields!", Util.createAccountValidateData("aaa", "aaa", "", "123", "123"));
//	}
//
//	@Test
//	void test4EmptyFieldExistOnCreateAccountPage() {
//		assertEquals("Please fill in all the fields!",
//				Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", "", "123"));
//	}
//
//	@Test
//	void test5EmptyFieldExistOnCreateAccountPage() {
//		assertEquals("Please fill in all the fields!",
//				Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", "123", ""));
//	}
//
//	// input contains space on create account page
//	@Test
//	void test1InputContainsSpaceOnCreateAccountPage() {
//		assertEquals("No spaces allowed!", Util.createAccountValidateData(" ", "aaa", "aaa@sina.com", "123", "123"));
//	}
//
//	@Test
//	void test2InputContainsSpaceOnCreateAccountPage() {
//		assertEquals("No spaces allowed!", Util.createAccountValidateData("aaa", " ", "aaa@sina.com", "123", "123"));
//	}
//
//	@Test
//	void test3InputContainsSpaceOnCreateAccountPage() {
//		assertEquals("No spaces allowed!", Util.createAccountValidateData("aaa", "aaa", " ", "123", "123"));
//	}
//
//	@Test
//	void test4InputContainsSpaceOnCreateAccountPage() {
//		assertEquals("No spaces allowed!", Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", " ", "123"));
//	}
//
//	@Test
//	void test5InputContainsSpaceOnCreateAccountPage() {
//		assertEquals("No spaces allowed!", Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", "123", " "));
//	}
//
//	// Password does not match
//	@Test
//	void test1UnmatchedPasswordOnCreateAccountPage() {
//		assertEquals("Password does not match! ",
//				Util.createAccountValidateData("aaa", "aaa", "aaa@sina.com", "123", "124"));
//	}
//
//	// valid input on login page
//	@Test
//	void testValidInputOnLoginPage() {
//		assertEquals("", Util.loginValidateData("aaa", "aaa@sina.com", "123"));
//	}
//
//	// empty field exists on login page
//	@Test
//	void test1EmptyFieldExistOnLoginPage() {
//		assertEquals("Login failed! Please check the household name, your email and password!",
//				Util.loginValidateData("", "aaa@sina.com", "123"));
//	}
//
//	@Test
//	void test2EmptyFieldExistOnLoginPage() {
//		assertEquals("Login failed! Please check the household name, your email and password!",
//				Util.loginValidateData("aaa", "", "123"));
//	}
//
//	@Test
//	void test3EmptyFieldExistOnLoginPage() {
//		assertEquals("Login failed! Please check the household name, your email and password!",
//				Util.loginValidateData("aaa", "aaa@sina.com", ""));
//	}
//
//	// valid input on add a chore page
//	@Test
//	void test1ValidInputOnAddAChorePage() {
//		assertEquals("", Util.addAChoreValidateData("laundry", "weekly", "06:30", true, false, "Richard"));
//	}
//
//	@Test
//	void test2ValidInputOnAddAChorePage() {
//		assertEquals("", Util.addAChoreValidateData("laundry", "weekly", "06:30", false, true, ""));
//	}

	// empty field exists on add a chore page
	@Test
	void test1EmptyFieldExistOnAddAChorePage() {
		assertEquals("Please select all items!",
				Util.addAChoreValidateData(null, "weekly", "06:30", true, false, "Richard"));
	}

	@Test
	void test2EmptyFieldExistOnAddAChorePage() {
		assertEquals("Please select all items!",
				Util.addAChoreValidateData("laundry", null, "06:30", true, false, "Richard"));
	}

	@Test
	void test3EmptyFieldExistOnAddAChorePage() {
		assertEquals("Please select all items!",
				Util.addAChoreValidateData("laundry", "weekly", null, true, false, "Richard"));
	}

	@Test
	void test4EmptyFieldExistOnAddAChorePage() {
		assertEquals("Please select all items!",
				Util.addAChoreValidateData("laundry", "weekly", "06:30", true, false, null));
	}

	@Test
	void test5EmptyFieldExistOnAddAChorePage() {
		assertEquals("Please select all items!",
				Util.addAChoreValidateData("laundry", "weekly", "06:30", false, false, null));
	}

}

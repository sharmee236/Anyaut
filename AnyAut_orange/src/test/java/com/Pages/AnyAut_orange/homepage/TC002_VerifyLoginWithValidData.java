package com.Pages.AnyAut_orange.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.AnyAut_orange.testBase.TestBase;
import com.Pages.AnyAut_orange.uiActions.HomePage;

public class TC002_VerifyLoginWithValidData extends TestBase  {
	HomePage homepage;
	String email= "funrun778@abc.com", 
			passwrd= "12345678";
	
	@BeforeClass
	public void setUp(){
		init();
	}
	@Test 
	public void testValidLogin (){
		log.info("===========Starting ValidLogin Test================= ");
		homepage = new HomePage(driver);
		homepage.loginToApplication(email, passwrd);
		Assert.assertEquals(false, homepage.verifyLoginText());
		
	}
	
	
	@AfterTest
	public void endTest(){
		driver.quit();
	}

}

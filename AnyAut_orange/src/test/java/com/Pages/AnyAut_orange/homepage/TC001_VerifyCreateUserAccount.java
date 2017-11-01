package com.Pages.AnyAut_orange.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.AnyAut_orange.testBase.TestBase;
import com.Pages.AnyAut_orange.uiActions.HomePage;

public class TC001_VerifyCreateUserAccount extends TestBase {
	HomePage homepage;
	String firstname = "fun", 
			lastname= "run", 
			email= "funrun778@abc.com", 
			passwrd= "12345678", 
			CompName= "funrun", 
			designtn= "boss", 
			phNo= "1112223456", 
			cntry = "US";
			
	
	@BeforeClass
	public void setUp(){
		init();
	}
	@Test
	public void testCreateAccount() throws InterruptedException{
		log.info("===========Starting CreateUserAccount Test================= ");
		homepage = new HomePage(driver);
		homepage.createUserAccount(firstname, lastname, email, passwrd, CompName, designtn, phNo, cntry);
		homepage.getMassageText();
		Thread.sleep(5000);
		
	//Assert.assertEquals(homepage.getMassageText(), "");
	}
	@AfterClass
	public void endTest(){
		//driver.quit();
	}
	

}

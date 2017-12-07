package com.Pages.AnyAut_orange.homepage;

//import org.testng.Assert;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.AnyAut_orange.testBase.TestBase;
import com.Pages.AnyAut_orange.uiActions.HomePage;

public class VerifyLoginWithDifferentData extends TestBase  {
	HomePage homepage;
	/*String email= "funrun778@abc.com", 
			passwrd= "12345678";*/
	
	@DataProvider(name="loginTestData")
	public String[][] getTestData(){
		String[][] testRecords = getData("DataSheet.xlsx", "LoginTestData");
		return testRecords;
		
	}
	
	@BeforeClass
	public void setUp(){
		init();
	}
	
	@Test (dataProvider = "loginTestData")
	public void testValidLogin (String email, String password, String runmode){
		
		if (runmode.equalsIgnoreCase("n")){
			throw new SkipException("user mark this record as no run");
			
		}
		log.info("===========Starting VerifyLoginWithDifferentData Test================= ");
		homepage = new HomePage(driver);
		homepage.loginToApplication(email, password);
		//Assert.assertEquals(true, homepage.verifyLoginText());
		getScreenShot(email);
		log.info("===========ending VerifyLoginWithDifferentData Test================= ");
		
	
	}
	@AfterTest
	public void endTest(){
		driver.quit();
	}

}

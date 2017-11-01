package com.Pages.AnyAut_orange.homepage;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.AnyAut_orange.testBase.TestBase;
import com.Pages.AnyAut_orange.uiActions.HomePage;

public class TC003_VerifyLoginWithInvalidData extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithInvalidData.class.getName());
	HomePage homepage;
	
	@BeforeTest
	public void setUp(){
		init();		
	}
	@Test
	public void verifyLoginWithInvalidData(){
		log.info("======Starting VerifyLoginWithInvalidData Test=======");
		homepage = new HomePage(driver);
		homepage.loginToApplication("asd@gmail.com", "1234");
		Assert.assertEquals(homepage.getMassageText(), "  Invalid Email (or) Password");
		log.info("======finished VerifyLoginWithInvalidData Test=======");
	}
	@AfterTest
	public void endTest(){
		driver.close();
		
	}

}

package com.Pages.AnyAut_orange.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	//public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = "https://anyaut.com/orange";
	String browser = "firefox";
	
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jconfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfPath);
		org.apache.log4j.BasicConfigurator.configure();
		//PropertyConfigurator.configure(log4jconfPath);
	}
	
	public void selectBrowser(String browser){
		//for chrome driver
				/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\Firefox Driver\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();*/
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Public\\Documents\\Firefox Driver\\geckodriver-v0.18.0-win64\\geckodriver.exe");

		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/drivers/geckodriver.exe");
			log.info("creating object of "+ browser);
			
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")){
			System.out.println("directory is "+ System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("IE")){
			
		}
	}
	
	public void getUrl (String url){
		log.info("navigating to : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

}

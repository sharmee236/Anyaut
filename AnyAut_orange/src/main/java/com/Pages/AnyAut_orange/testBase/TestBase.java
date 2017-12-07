package com.Pages.AnyAut_orange.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;





import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.Pages.AnyAut_orange.excelReader.Excel_Reader;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	//public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = "https://anyaut.com/orange";
	String browser = "firefox";
	Excel_Reader excel;
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
	
	public String[][] getData(String excelName, String sheetName){
		//\src\main\java\com\Pages\AnyAut_orange\data\DataSheet.xlsx
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\Pages\\AnyAut_orange\\data\\" + excelName;
		excel = new Excel_Reader (path);
		System.out.println(path);
		String [][] data=excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	
	public void getScreenShot (String name){
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat ("MM_dd_yyyy_hh_mm_ss");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
		String reportDirectory = new File (System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\Pages\\AnyAut_orange\\screenshot\\";
		System.out.println("reportDirectory is " +reportDirectory);
		File destFile = new File((String)reportDirectory + name + "_" + formater.format(calender.getTime()) + ".png");
		System.out.println("destFile is " + destFile);
		
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a herf = '"+ destFile.getAbsolutePath()+ "'><img src='" +destFile.getAbsolutePath() + "'height = '100' width= '100'/></a/");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

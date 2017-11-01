package com.Pages.AnyAut_orange.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(className="login-button")
	WebElement logIn;
	
	@FindBy(id="username")
	WebElement loginUsername;
	
	@FindBy(id="password")
	WebElement loginPassword;
	
	@FindBy(id="singlebutton")
	WebElement signIn;
	
	@FindBy(id="alert-error")
	WebElement getMassageText;
	
	@FindBy(className="register-button")
	WebElement joinUsLink;
	
	@FindBy(id="firstname")
	WebElement firstnameBox;
	
	@FindBy(id="lastname")
	WebElement lastnameBox;
	
	@FindBy(id="email")
	WebElement emailBox;
	
	@FindBy(id="password")
	WebElement passwordEdBox;
	
	@FindBy(id="confirmpassword")
	WebElement confrmPasswordEdBox;
	
	@FindBy(id="singlebutton")
	WebElement proceedBtn;
	
	@FindBy(id="company")
	WebElement companyBox;
	
	@FindBy(id="designation")
	WebElement designationBox;
	
	@FindBy(id="phone")
	WebElement phoneNoBox;
	
	@FindBy(id="country")
	WebElement countryBox;
	
	
	@FindBy(name="register")
	WebElement registerBtn;
	
	
	public HomePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String password){
		logIn.click();
		log.info("clicked on login and object is: "+ logIn.toString());
		loginUsername.sendKeys(email);
		log.info("entered email address and object is: "+ loginUsername.toString());
		loginPassword.sendKeys(password);
		log.info("entered password and object is: "+ loginPassword.toString());
		signIn.click();
		log.info("clicked on signin button and object is: "+ signIn.toString());
	}
	
	
	
	public void createUserAccount(String firstname, String lastname, String email, String passwrd,String CompName, String designtn, String phNo, String cntry ) throws InterruptedException{
		joinUsLink.click();
		log.info("clicked on Join button and object is: " + joinUsLink.toString());
		firstnameBox.clear();
		firstnameBox.sendKeys(firstname);
		lastnameBox.clear();
		lastnameBox.sendKeys(lastname);
		emailBox.clear();
		emailBox.sendKeys(email);
		passwordEdBox.clear();
		passwordEdBox.sendKeys(passwrd);
		confrmPasswordEdBox.clear();
		confrmPasswordEdBox.sendKeys(passwrd);
		proceedBtn.click();
		log.info("clicked on proceed button and object is: " + proceedBtn.toString());
		Thread.sleep(5000);
		companyBox.clear();
		companyBox.sendKeys(CompName);
		designationBox.clear();
		designationBox.sendKeys(designtn);
		phoneNoBox.clear();
		phoneNoBox.sendKeys(phNo);
		Select s = new Select(countryBox);
		s.selectByValue(cntry);
		registerBtn.click();
		log.info("clicked on register button and object is :"+ registerBtn.toString());
	
		
	}
	
	public boolean verifyLoginText(){
		try {
			driver.findElement(By.className("profile_info")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public String getMassageText(){
		log.info("error massage is: " +getMassageText.getText());
		return getMassageText.getText();
	}
	

	}	
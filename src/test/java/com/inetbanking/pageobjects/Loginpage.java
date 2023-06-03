package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
			
	}
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//strong[@class='ng-tns-c3-0']")
	@CacheLookup
	WebElement dntsellpsnlinfobtn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	
	public void setUsername(String uname) {
		
		txtUsername.sendKeys(uname);
	}
	
	
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
 
	
	
	
	public void clickSubmit() {
		
		btnlogin.click();
		
		
	}
	
	public void clickLogout() {
		
		lnkLogout.click();
		
	}


	
	
	
	
}

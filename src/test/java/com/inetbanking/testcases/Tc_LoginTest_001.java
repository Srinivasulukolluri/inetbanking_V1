package com.inetbanking.testcases;


import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;


public class Tc_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		driver.get(Url);
		Logger.info("URL is Opened");
		
		driver.manage().window().maximize();
		
		Logger.info("Window is Maximised");
		
		Thread.sleep(5000);
		
	
		Loginpage lp = new Loginpage(driver);
		
		
		lp.setUsername(username);
		
		Logger.info("Username Entered ");
		
		lp.setPassword(password);
		
		Logger.info("Password Entered ");
		
		lp.clickSubmit();
		
		Logger.info("Submited and Entered to mail page");
		
		

		
			if(driver.getTitle().equals(" GTPL Bank Home Page")) {
			
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else {
			
			captureScreen(driver,"LoginTest");
			Assert.assertFalse(false);
			Logger.info("login test failed");
		}
		
		
	}
	


}

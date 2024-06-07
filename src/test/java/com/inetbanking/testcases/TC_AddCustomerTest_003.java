package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver.Window;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.Loginpage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
		Loginpage lp = new Loginpage(driver);
		lp.setUsername(username);
		
		Logger.info("username is provided");
		lp.setPassword(password);
		Logger.info("password is provided");
		lp.clickSubmit();
		
		
        AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Logger.info("provideding customer details");
		addcust.cusName("srinivas");
		addcust.custgender("male");
		addcust.custdob("12", "31", "1979");
		Thread.sleep(3000);
		addcust.custaddress("washington ave");
		addcust.custcity("albany");
		addcust.custstate("NY");
		addcust.custpinno("122061");
		addcust.custelephoneno("9876543219");
				
		String email=randomstring()+"@gmail.com";
		addcust.cusemailid(email);
		addcust.custpassword("Omn@12");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains( "Customer Registered Successfully!!!");
	
	    if(res==true) 
	    {
	    Assert.assertTrue(true);	
	    }
	    else {
	    	captureScreen(driver,"addNewCustomer");
	    	Assert.assertTrue(false);
	    }
	}
	

}

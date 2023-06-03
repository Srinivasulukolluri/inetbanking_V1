package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="testdata")
	public void loginDDT(String user, String pwd) throws Exception 
	
	{
		Loginpage lp = new Loginpage(driver);
		
		Thread.sleep(3000);
		lp.setUsername(user);
		Logger.info("username provided");
		lp.setPassword(pwd);
		Logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresant()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			AssertJUnit.assertTrue(false);
			Logger.warn("Login Failed");
		}
		else {
			AssertJUnit.assertTrue(true);
			Logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
				
	}
	
	public boolean isAlertPresant()
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="testdata")
	String [][] getData() throws IOException
	
	{
		
		String path= System.getProperty("/Users/srinivasulukolluri/java-2022-124/Eclipse.app/inetbankingV1/src/test/java/com/inetbanking/testdata/testdata.xlsx");
		
		
	   
		int rownum = XLUtils.getRowCount(path,"Sheet1");
	    int colcount=XLUtils.getCellCount(path, "Sheet1",1);
	    
	    String logindata[][]=new String [rownum][colcount];
	    
	    for(int i=1;i<=rownum;i++)
	    {
	    for (int j=0;j<colcount;j++) 
	    {
	    	logindata[i-1][j]=XLUtils.getcellData(path,"Sheet1",i,j);	
	    }
	    	
	    }
	    return logindata;
	}

}

package com.inetbanking.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String Url = readconfig.getApplicationUrl();
	public String username =readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger Logger;
	
	
@Parameters("browser")
@BeforeClass

public void setup(String br) throws Exception {
	
	
	Logger = org.apache.log4j.Logger.getLogger(TC_LoginDDT_002.class);
	String log4jConfPath = System.getProperty("user.dir")+File.separator+"log4j.properties";
	
	PropertyConfigurator.configure(log4jConfPath);
	

	
	
	if (br.equals("chrome")) {
		
	System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
	
	
	

	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	
	}
	else if(br.equals("safari")) {
		
		
		System.setProperty("webdriver.safari.driver",readconfig.getSafaripath());
		driver = new SafariDriver();
		driver.manage().window().maximize();
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get(Url);
	
	
}

@AfterClass
public void tearDown() {
	
	driver.quit();
}

public void captureScreen(WebDriver driver, String tname) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot Taken");
	
}

public String randomstring() 
{
	
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
}

public static String randomenum() 

{
	String generatedstring2=RandomStringUtils.randomNumeric(4);
	return (generatedstring2);
}

	

}

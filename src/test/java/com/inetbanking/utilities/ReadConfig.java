package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()  {
		
		File src = new File("./configurationfiles/config.properties");
		try {
		FileInputStream fis= new FileInputStream(src);
		
		pro= new Properties();
		pro.load(fis);
		} catch (IOException e) {
			
			System.out.println("Exception is  "+e.getMessage());
		}
			
		
		}
	
	public ReadConfig(Properties pro) {
		super();
		this.pro = pro;
	}

	public String getApplicationUrl() {
		
		String url = pro.getProperty("baseurl");
		return url;
		
	}
	
	public String getUsername() {
		
		String username=pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getSafaripath() {
		
		String safaripath = pro.getProperty("safaripath");
		return safaripath;
	}
		
	}
	




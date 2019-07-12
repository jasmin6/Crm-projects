package com.ComCast.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.ObjectRepositorylib.HomePage;
import com.vtiger.ObjectRepositorylib.LoginPage;

public class Baseclass { 
	public static WebDriverCommonUtils wcomn = new WebDriverCommonUtils();
	public static WebDriver driver;
	public static FileLib fLib = new FileLib();
	
	@BeforeClass
	public void configBC() throws IOException {
		/** 
		 * get browser data from property file
		 */
		String browserName = fLib.getProprtykeyvalue("browser");
		if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	 @BeforeMethod
	 public void configBM() throws IOException {
		String URL =  fLib.getProprtykeyvalue("url");
		String USER = fLib.getProprtykeyvalue("username");
		String PASSWORD = fLib.getProprtykeyvalue("password");
	    driver.get(URL);
	    LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
	    lp.loginToApp(USER,PASSWORD);
	    
		
	}
	@AfterMethod 
	 public void configAM() {
		 HomePage hp = PageFactory.initElements(driver, HomePage.class);
		 hp.getLogoutImg();
	 }
	 @AfterClass
	 public void configAC() {
		 driver.close();
	 }

}

	

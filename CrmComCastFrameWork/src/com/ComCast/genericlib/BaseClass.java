package com.ComCast.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	public FileLib fLib = new FileLib();

   @BeforeClass
   public void configBC()
   {
	   System.out.println("Launch Browser");
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }
   @BeforeMethod
   public void configBM() throws IOException
   {
	   System.out.println("login");
	   driver.get(fLib.getProprtykeyvalue("url"));
	   driver.findElement(By.name("user_name")).sendKeys(fLib.getProprtykeyvalue("username"));
       driver.findElement(By.name("user_password")).sendKeys(fLib.getProprtykeyvalue("password"));
	   driver.findElement(By.id("submitButton")).click();
	   
   }
   @AfterMethod
   public void configAM()
   {
	   Actions act = new Actions(driver);
	   System.out.println("logout");
	   act.moveToElement(driver.findElement(By.xpath("//td[@class='small' and @valign='bottom'][1]/img"))).perform();
	   driver.findElement(By.linkText("Sign Out")).click();
	  
	   
	   
   }
   @AfterClass
   public void configAC()
   {
	   System.out.println("close browsr");
	   driver.close();
   }
   
}
   
	
	




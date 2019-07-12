package com.ComCast.Export_Opportunities;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.testng.annotations.Test;

import com.ComCast.genericlib.BaseClass;

public class Export_Oppertunities extends BaseClass {
	@Test
	public void opportunity_Export_File() throws EncryptedDocumentException, IOException, InterruptedException {
		
	
	
	/* create organisation */
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...'and @alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(fLib.getExcelData("sheet1", 3, 1));
	driver.findElement(By.xpath("(//input[@type='button'and @name='button'])[1]")).click();
	/*driver.navigate().back();*/
	
	/* create ooportunity*/
	Thread.sleep(3000);

	driver.findElement(By.linkText("Opportunities")).click();
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
    driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and @name='potentialname']")).sendKeys(fLib.getExcelData("sheet1", 3, 0));
    driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
    
    Set<String> set = driver.getWindowHandles();
    Iterator<String> itr = set.iterator();
    String parentId = itr.next();
    String childId = itr.next();
    driver.switchTo().window(childId);
    driver.findElement(By.id("search_txt")).sendKeys(fLib.getExcelData("sheet1", 1, 1));
    driver.findElement(By.name("search")).click();
    driver.findElement(By.xpath("//a[text()='samsung12']")).click();
    driver.switchTo().window(parentId);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    
    //driver.findElement(By.linkText("Opportunities")).click();
    
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("browser.download.folderList", 2);
    profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
    profile.setPreference("browser.download.dir", "E://");
    
    driver.findElement(By.linkText("Opportunities")).click();
    driver.findElement(By.xpath("//img[@alt='Export Opportunities']")).click();
    driver.findElement(By.xpath("//input[@value='Export Opportunities ']")).click();
    WebElement webE = driver.findElement(By.xpath("//td[@class='mailClientBg  genHeaderSmall']"));
    String actMsg = webE.getText();
    String expMsg = "Opportunities >> Export";
    
    if(actMsg.contains(expMsg)) {
    	System.out.println("OPPERTUNITIES EXPORETED SUCCESFULLY===PASS");
    }
    else {
    	System.out.println("FAIL");
    }
    
    
    
    
    
    
    
    
	}
}


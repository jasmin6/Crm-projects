package com.ComCast.FindDup_Opportunities;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ComCast.genericlib.BaseClass;


public class FindDup_Opportunities extends BaseClass{
	@Test
	public void opportunity_nodata_dup() throws EncryptedDocumentException, IOException, InterruptedException {
		/* create organization */
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...'and @alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(fLib.getExcelData("sheet1", 1, 1));
		driver.findElement(By.xpath("(//input[@type='button'and @name='button'])[1]")).click();
		
		
		/* create ooportunity*/
		Thread.sleep(3000);
	
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
        driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and @name='potentialname']")).sendKeys(fLib.getExcelData("sheet1", 1, 0));
        driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
        
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String parentId = itr.next();
        String childId = itr.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("search_txt")).sendKeys(fLib.getExcelData("sheet1", 1, 1));
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath("//a[text()='samsung10']")).click();
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        driver.findElement(By.linkText("Opportunities")).click();
        driver.findElement(By.xpath("//img[@title='Find Duplicates']")).click();
		WebElement wb1 = driver.findElement(By.xpath("//select[@id='availList']"));
		Select scl = new Select(wb1);
		scl.selectByVisibleText("Opportunity Name");
		driver.findElement(By.xpath("//input[@class='crmButton small'][1]"));
		driver.findElement(By.xpath("//input[@value='Find Duplicates']")).click();
		WebElement we= driver.findElement(By.xpath("//span[text()='No Duplicate Records']"));
		String expMsg = "No Duplicate Records";
		String actMsg = we.getText();
		if (actMsg.equals(expMsg))
		{
			System.out.println("Message is verifies==>Pass");
		}
		else 
		{
			System.out.println("Message is verifies==>Fail");
		}
		
		

	}

}

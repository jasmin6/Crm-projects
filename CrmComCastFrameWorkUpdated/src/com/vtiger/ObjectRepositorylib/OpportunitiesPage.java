package com.vtiger.ObjectRepositorylib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ComCast.genericlib.Baseclass;
import com.ComCast.genericlib.WebDriverCommonUtils;

public class OpportunitiesPage extends Baseclass {
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunityImg;
	
	@FindBy(xpath = "//input[@class='detailedViewTextBox'and @name='potentialname']")
	private WebElement opportunityNameTxt;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement relatedToImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@title='Find Duplicates']")
	private WebElement findDupImg;
	
	@FindBy(xpath = "//input[@class='crmButton small'][1]")
	private WebElement crmBtn;
	
	@FindBy(xpath = "//input[@value='Find Duplicates']")
	private WebElement findDupBtn;
	
	@FindBy(xpath = "//span[text()='No Duplicate Records']")
	private WebElement actMsg;
	
	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;
	
	public void createOpportunity(String opportunityName ) throws EncryptedDocumentException, IOException {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOpportunities();
		createOpportunityImg.click();
		opportunityNameTxt.sendKeys(opportunityName);
		relatedToImg.click();
		OpportunitiesLookUpPage oppLookUp = PageFactory.initElements(driver, OpportunitiesLookUpPage.class);
		wcomn.getWindowIDs();
		
		driver.switchTo().window(WebDriverCommonUtils.childWindowID);
		oppLookUp.getSearchTxt().sendKeys(fLib.getExcelData("sheet1", 1, 1));
		oppLookUp.getSearchNowBtn().click();
		oppLookUp.getOrgNameLst().click();
		driver.switchTo().window(WebDriverCommonUtils.parentWindowID);
		saveBtn.click();
		
		}


	public WebElement getFindDupImg() {
		return findDupImg;
	}
	
	


	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	public WebElement getCrmBtn() {
		return crmBtn;
	}


	public WebElement getFindDupBtn() {
		return findDupBtn;
	}


	public WebElement getActMsg() {
		return actMsg;
	}
	
	
		
	
	
	
	
	
	
	
	

}

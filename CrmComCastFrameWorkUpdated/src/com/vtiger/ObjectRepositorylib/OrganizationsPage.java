package com.vtiger.ObjectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ComCast.genericlib.Baseclass;

public class OrganizationsPage extends Baseclass {
	
	@FindBy(xpath = "//img[@title='Create Organization...'and @alt='Create Organization...']")
	private WebElement createOrganization;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement  OrganizationNameEdt;
	
	@FindBy(xpath = "(//input[@type='button'and @name='button'])[1]")
	private WebElement saveBtn;
	
	public void createOrganizations(String organizationName) {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizations();
		createOrganization.click();
		OrganizationNameEdt.sendKeys(organizationName);
		saveBtn.click();
		}
	
	
	
	
	
	
	

}

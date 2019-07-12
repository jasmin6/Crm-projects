package com.vtiger.ObjectRepositorylib;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import com.ComCast.genericlib.Baseclass;

public class HomePage extends Baseclass{
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement  opportunitiesLnk;
	
	@FindBy(xpath = "xpath(\"//td[@class='small' and @valign='bottom'][1]/img\")")
	private WebElement logoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	public void navigateToOrganizations(){
		organizationsLnk.click();
		}
	
	public void navigateToOpportunities(){
		opportunitiesLnk.click();
		}
	

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	
	

	public void signOut(){
		signoutLnk.click();
		}
	
	
	
	
	

	
	
	

}

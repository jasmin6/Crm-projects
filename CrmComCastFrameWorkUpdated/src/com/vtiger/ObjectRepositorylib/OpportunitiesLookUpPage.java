package com.vtiger.ObjectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesLookUpPage {
	@FindBy(id = "search_txt")
	private WebElement searchTxt;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy (id = "1")
	private WebElement orgNameLst;

	public WebElement getSearchTxt() {
		return searchTxt;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getOrgNameLst() {
		return orgNameLst;
	}
	
	
	

}

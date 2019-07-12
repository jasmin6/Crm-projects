package com.ComCast.FindDup_Opportunities1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ComCast.genericlib.Baseclass;
import com.vtiger.ObjectRepositorylib.HomePage;
import com.vtiger.ObjectRepositorylib.OpportunitiesPage;
import com.vtiger.ObjectRepositorylib.OrganizationsPage;

public class Opportunity_Cancel_button extends Baseclass {
	@Test
	public void opportunity_nodata_dup()throws EncryptedDocumentException, IOException, InterruptedException {

	/*Create Organization*/
	String organizationName = fLib.getExcelData("sheet1", 1, 1);
	OrganizationsPage orgPage = PageFactory.initElements(driver, OrganizationsPage.class);
	orgPage.createOrganizations(organizationName);
	
	/*
	 * Create Opportunities
	 */
	Thread.sleep(3000);
	String opportunityName = fLib.getExcelData("sheet1", 1, 0);
	OpportunitiesPage oppPage = PageFactory.initElements(driver, OpportunitiesPage.class);
	oppPage.createOpportunity(opportunityName);
	
	
	/*
	 * Click on FindDuplicateImage
	 */
	Thread.sleep(2000);
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	hp.navigateToOpportunities();
	oppPage.getFindDupImg().click();
	oppPage.getCrmBtn().click();
	oppPage.getCancelBtn().click();

	}
}




package com.icj.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icj.base.TestBase_ICJ;
import com.pages.icj.ICJ_UAT_DashBoardPage;
import com.pages.icj.ICJ_UAT_ExistingSubscriptionDetailPage;
import com.pages.icj.ICJ_UAT_LoginPage;
import com.pages.icj.ICJ_UAT_NewSubScriptionPage;
import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_ExistingSubscriptionDetailPageTest extends TestBase_ICJ{
	ICJ_UAT_LoginPage icjuatloginpage;
	ICJ_UAT_ExistingSubscriptionDetailPage icjuatexistingsubscriptiondetailpage;
	ICJ_UAT_DashBoardPage icjuatdashboardpage;
	
	
	@BeforeMethod
	public void preBase() {
		setUp();
		icjuatloginpage = new ICJ_UAT_LoginPage(driver);
		icjuatdashboardpage = icjuatloginpage.verrifyLoginWithADID();
		icjuatexistingsubscriptiondetailpage =  icjuatdashboardpage.existingSubscriberclick();
		
		
	}
	@Test
	public void testWithSubscriberDetail() throws InterruptedException {
		icjuatexistingsubscriptiondetailpage.enterAllTheSubscriptionDetail();
	}

	
	
	
	
	
		
}

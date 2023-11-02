package com.icj.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icj.base.TestBase_ICJ;
import com.pages.icj.ICJ_UAT_DashBoardPage;
import com.pages.icj.ICJ_UAT_LoginPage;
import com.pages.icj.ICJ_UAT_NewSubScriptionPage;
import com.pages.icj.ICJ_UAT_SubscriptionDetailPage;
import com.utilis.WaitUtilities;

public class ICJ_UAT_SubscriptionDetailPageTest extends TestBase_ICJ{
	ICJ_UAT_LoginPage icjuatloginpage;
	ICJ_UAT_NewSubScriptionPage icjuatnewsubscriptionpage;
	ICJ_UAT_DashBoardPage icjuatdashboardpage;
	ICJ_UAT_SubscriptionDetailPage icjuatsubscriptiondetailpage;
	
	WaitUtilities waitUtils;
	
	@BeforeMethod
	public void preBase() throws InterruptedException {
		setUp();
		 waitUtils = new WaitUtilities();
		icjuatloginpage = new ICJ_UAT_LoginPage(driver);
		icjuatdashboardpage = icjuatloginpage.verrifyLoginWithADID();
		waitUtils.waitForPageToLoad(driver, 1);
		icjuatnewsubscriptionpage = icjuatdashboardpage.clickOnNewSubscription();
		waitUtils.waitForPageToLoad(driver, 1);
		icjuatsubscriptiondetailpage = icjuatnewsubscriptionpage.enternewsubscriptionandenterSubscriptionDetail();
		waitUtils.waitForPageToLoad(driver, 1);
	}
	
	
	
	@Test(invocationCount = 1)
	public void testWithSubscriptiondetailform() throws InterruptedException {
		icjuatsubscriptiondetailpage.enterAllTheSubscriptionDetail();
	}
	
	
	@AfterMethod
	public void closeTest() {
		tearDown();
	}
}





package com.icj.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icj.base.TestBase_ICJ;
import com.pages.icj.ICJ_UAT_DashBoardPage;
import com.pages.icj.ICJ_UAT_LoginPage;
import com.pages.icj.ICJ_UAT_NewSubScriptionPage;

public class ICJ_UAT_DashBoardPageTest extends TestBase_ICJ{
	ICJ_UAT_LoginPage icjuatloginpage;
	
	ICJ_UAT_DashBoardPage icjuatdashboardpage;
	
	
	@BeforeMethod
	public void preBase() {
		setUp();
		icjuatloginpage = new ICJ_UAT_LoginPage(driver);
		icjuatdashboardpage = icjuatloginpage.verrifyLoginWithADID();
		
	}
	
	
	@Test
	public void testWithEnteringNewSubscriberDetail() throws InterruptedException {
		icjuatdashboardpage.clickOnNewSubscription();
		boolean diplayed = driver.findElement(By.id("txt_firstName")).isDisplayed();
		Assert.assertTrue(diplayed);
		
	}

@AfterMethod
public void closeTest() {
tearDown();
}}


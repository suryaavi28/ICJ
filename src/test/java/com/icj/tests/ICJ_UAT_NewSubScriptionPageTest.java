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
import com.utilis.WaitUtilities;


public class ICJ_UAT_NewSubScriptionPageTest extends TestBase_ICJ{
		ICJ_UAT_LoginPage icjuatloginpage;
		ICJ_UAT_NewSubScriptionPage icjuatnewsubscriptionpage;
		ICJ_UAT_DashBoardPage icjuatdashboardpage;
		WaitUtilities waitUtils;
		
		
		@BeforeMethod
		public void preBase() {
			setUp();
			waitUtils= new WaitUtilities();
			icjuatloginpage = new ICJ_UAT_LoginPage(driver);
			icjuatdashboardpage = icjuatloginpage.verrifyLoginWithADID();
			waitUtils.waitForPageToLoad(driver, 1);
			icjuatnewsubscriptionpage = icjuatdashboardpage.clickOnNewSubscription();
			waitUtils.waitForPageToLoad(driver, 1);
			
		}
		
		
		@Test(invocationCount =2)
		public void testWithEnteringNewSubscriberDetail() throws InterruptedException {
			icjuatnewsubscriptionpage.verifyWithAllTheDetails();
			boolean actual = driver.findElement(By.xpath("//button[normalize-space()='New Subscription']")).isDisplayed();
			Assert.assertTrue(actual);
			String newid = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
			String Previousid = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
			
			
		}
		
		@Test
		public void testWithValidatingErrorMessages() throws InterruptedException {
			icjuatnewsubscriptionpage.validateErrorMessage();
			
		}
		
		
			
@AfterMethod
public void closeTest() {
	tearDown();
}}
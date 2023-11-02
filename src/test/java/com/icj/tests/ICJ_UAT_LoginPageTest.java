package com.icj.tests;


import org.openqa.selenium.By;import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icj.base.TestBase_ICJ;
import com.pages.icj.ICJ_UAT_LoginPage;
import com.utilis.ReadConfigUtilities;

public class ICJ_UAT_LoginPageTest extends TestBase_ICJ{
	ICJ_UAT_LoginPage icjuatloginpage;
	
	@BeforeMethod
	public void preBase() {
		setUp();
		icjuatloginpage = new ICJ_UAT_LoginPage(driver);
	}
	
	@Test
	public void testTitleOfThePage() {
		String expected = "ICJ";
		String actual =icjuatloginpage.titleOfPageAcc();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testWithValidCredentials() {
	icjuatloginpage.verrifyLoginWithADID();
	boolean isLoginsuccessful = driver.findElement(By.xpath("//th[normalize-space()='ICJ Number']")).isDisplayed();
	if (isLoginsuccessful==true) {
		Assert.assertTrue(true); }else {Assert.assertTrue(false);
	}
	}
	@Test
	public void testWithFooterLabel() {
		String label= icjuatloginpage.verifyFooterLabel();
		String actual = label.trim().replaceAll("\\s+", " ");
		String expected = "©ICJ";
		
		Assert.assertEquals(label, expected);
	}
	
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
}

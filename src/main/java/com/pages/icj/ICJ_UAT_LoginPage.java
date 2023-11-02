package com.pages.icj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_LoginPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;


	public ICJ_UAT_LoginPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
        configUtils.readConfig();
	}
	
private	By username = By.id("username");
private   By password = By.id("password");
private By submitbuttonClick = By.xpath("//button[normalize-space()='Login']");
private  By footerLabel = By.xpath("//label[normalize-space()='©ICJ']");
	
	public String titleOfPageAcc() {
        return driver.getTitle();
    }
	
	  public void enterUserName(String icj_username) {
	        WebElement un = waitUtils.waitForVisibility(driver, username, 10);
	        un.clear();
	        un.sendKeys(icj_username);
	    }
	  
	  public void enterPassWord(String icj_password) {
	        WebElement pw = waitUtils.waitForVisibility(driver, password, 10);
	        pw.clear();
	        pw.sendKeys(icj_password);
	    }
	  public void clickOnSubmitButton() {
	        WebElement btn = waitUtils.elementToBeClickable(driver, submitbuttonClick, 10);
	        btn.click();
	    }

	  public ICJ_UAT_DashBoardPage verrifyLoginWithADID() {
		  enterUserName(configUtils.getProperty("usernameICJ"));
		  enterPassWord(configUtils.getProperty("passwordICJ"));
		  clickOnSubmitButton();
		  return new ICJ_UAT_DashBoardPage(driver);
	  }
	  
	  public String verifyFooterLabel() {
		  String footerlabel = waitUtils.waitForVisibility(driver, footerLabel, 10).getText();
		  return footerlabel;
	  }
	  
	  
}

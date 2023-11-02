package com.pages.icj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_DashBoardPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;

	public ICJ_UAT_DashBoardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
        configUtils.readConfig();
	}
	
	private By newsubscription = By.xpath("//button[normalize-space()='New Subscription']");
	private By newidclick = By.xpath("//tbody/tr[1]/td[2]//a");
	private By SubscriptionDetailnew = By.xpath("//div[contains(text(),'Subscription Detail')]");
	private By searchinput = By.id("//input[@id='searchinput']");
	
	
	 public ICJ_UAT_NewSubScriptionPage clickOnNewSubscription() {
	        WebElement newsub = waitUtils.waitForVisibility(driver, newsubscription, 10);
	        newsub.click();
	        return new ICJ_UAT_NewSubScriptionPage(driver);
	    }
	  
	 
	public ICJ_UAT_ExistingSubscriptionDetailPage existingSubscriberclick() {
		WebElement subscriberfirst = waitUtils.waitForVisibility(driver,newidclick , 10);
		subscriberfirst.click();
		WebElement subscriberDetailclick = waitUtils.waitForVisibility(driver,SubscriptionDetailnew , 10);
		subscriberDetailclick.click();
		return new ICJ_UAT_ExistingSubscriptionDetailPage(driver);
		}
	}
	


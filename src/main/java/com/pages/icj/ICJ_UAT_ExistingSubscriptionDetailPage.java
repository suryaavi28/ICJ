package com.pages.icj;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_ExistingSubscriptionDetailPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Select select ;

	public ICJ_UAT_ExistingSubscriptionDetailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
        configUtils.readConfig();
	}
	
	By subscriptionperiod = By.id("dd_subscription_period");
	By subscriptiontype = By.id("dd_subscription_type");
	By deliverymode = By.id("dd_delivery_mode");
	By startmonth= By.id("dd_subs_start_month");
	By startyear = By.id("dd_subs_start_year");
	By endmonth = By.id("dd_subs_end_month");
	By endyear = By.id("dd_subs_end_year");
	By noofcopies = By.xpath("//input[@placeholder='Enter No. Of Copies']");
	By paymentmode= By.id("dd_payment_mode");
	By amount = By.xpath("//input[@placeholder='Enter Amount']");
	By chequeddutr = By.xpath("//input[@placeholder='Enter Cheque / DD / UTR No.']");
	By paymentdate = By.id("txt_payment_date");
	By bankname = By.id("dd_bank");
	By remark = By.xpath("//textarea[@placeholder='Enter Remark']");
	By backbutton = By.xpath("//button[normalize-space()='Back']");
	By savebutton = By.xpath("//button[normalize-space()='Save']");

	public void selectSubscriptionPeriod() {
		WebElement period= waitUtils.waitForVisibility(driver, subscriptionperiod, 4);
		 select = new Select (period);
		List<WebElement> options = select.getOptions();
		int randomPeriod= new Random().nextInt(options.size());
		select.selectByIndex(randomPeriod);
		
	
	}
	
	public void selectSubscriptionType() {
		WebElement type = waitUtils.waitForVisibility(driver, subscriptiontype, 4);
		 select = new Select (type);
		List<WebElement> options = select.getOptions();
		int randomType = new Random().nextInt(3);
		select.selectByIndex(randomType);
	}
	
	public void selectDeliveryMode() {
		WebElement mode = waitUtils.waitForVisibility(driver, deliverymode, 4);
		 select = new Select(mode);
		 List<WebElement> options = select.getOptions();
		 int randomMode = new Random().nextInt(options.size());
		 select.selectByIndex(randomMode);
	}
	
	public void enterAllTheSubscriptionDetail() throws InterruptedException {
		Thread.sleep(2000);
		selectSubscriptionPeriod();Thread.sleep(2000);
		selectSubscriptionType();Thread.sleep(2000);
		selectDeliveryMode();Thread.sleep(2000);
	}

}

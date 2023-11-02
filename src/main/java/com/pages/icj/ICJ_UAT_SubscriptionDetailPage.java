package com.pages.icj;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_SubscriptionDetailPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Select select;
	Random random;

	public ICJ_UAT_SubscriptionDetailPage(WebDriver driver) {
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
	By nextButton = By.xpath("//div[contains(text(),'Claims')]");

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
	public void selectSubscriptionStartMonth() {
		WebElement startmonths = waitUtils.waitForVisibility(driver, startmonth, 4);
		select = new Select(startmonths);
		List<WebElement> options = select.getOptions();
		int rstartmonth = new Random().nextInt(options.size());
		select.selectByIndex(rstartmonth);
	}
	
	public void selectSubscriptionStartYear() {
		WebElement startyears = waitUtils.waitForVisibility(driver, startyear, 4);
		select = new Select(startyears);
		List<WebElement> options = select.getOptions();
		int rstartyear = new Random().nextInt(options.size());
		select.selectByIndex(rstartyear);
	}
	
	public void selectSubscriptionEndMonth() {
		WebElement endmonths = waitUtils.waitForVisibility(driver, endmonth, 4);
		select = new Select(endmonths);
		List<WebElement> options = select.getOptions();
		int rendmonth = new Random().nextInt(options.size());
		select.selectByIndex(rendmonth);
	}
	
	public void selectSubscriptionEndYear() {
		WebElement endyears = waitUtils.waitForVisibility(driver, endyear, 4);
		select = new Select(endyears);
		List<WebElement> options = select.getOptions();
		int rendyear = new Random().nextInt(options.size());
		select.selectByIndex(rendyear);
	}
	
	public void enterNoOfCopies() {
		WebElement copies = waitUtils.waitForVisibility(driver, noofcopies, 4);
		random = new Random();
		int rancopies = random.nextInt(20);
		String nocopies = String.valueOf(rancopies);
		copies.sendKeys(nocopies);
	}
	public void enterPaymentMode() {
		
		WebElement mode= waitUtils.waitForVisibility(driver, paymentmode, 4);
		 select = new Select (mode);
		List<WebElement> options = select.getOptions();
		int rmode= new Random().nextInt(options.size());
		select.selectByIndex(rmode);	
	}
	
	public void EnterAmount() {
		random = new Random();
		int ramount = 2000 + random.nextInt(2000);
		String amounts = String.valueOf(ramount);
		WebElement amt = waitUtils.waitForPresence(driver, amount , 4);
		amt.clear();
		amt.sendKeys(amounts);
	}
	public void enterChequeDDUTRNo() {
		random = new Random();
		long chequeddut = 12123456789l + random.nextInt(1234664664);
		String chequeddutrs = String.valueOf(chequeddutr);
		WebElement cdu = waitUtils.waitForPresence(driver, chequeddutr , 4);
		cdu.clear();
		cdu.sendKeys(chequeddutrs);
	}
	public void selectPaymentDate() {
		random = new Random();
		int startYear = 2022;
		int endYear = 2024;

		// Generate a random year between startYear and endYear
		int year = random.nextInt(endYear - startYear + 1) + startYear;

		// Generate a random month between 1 and 12
		int month = random.nextInt(12) + 1;

		// Generate a random day between 1 and 28 (maxDay)
		int maxDay = 28;
		int day = random.nextInt(maxDay) + 1;

		// Format day, month, and year as two digits each
		String formattedDay = String.format("%02d", day);
		String formattedMonth = String.format("%02d", month);
		String formattedYear = String.format("%04d", year);

		// Create the formatted birthdate in "dd-MM-yyyy" format
		String paydate = formattedDay + "-" + formattedMonth + "-" + formattedYear;

		WebElement pd = waitUtils.waitForPresence(driver, paymentdate, 4);
		pd.sendKeys(paydate);
	}
	
public void selectBankName() {
		
		WebElement mode= waitUtils.waitForVisibility(driver, bankname, 4);
		 select = new Select (mode);
		List<WebElement> options = select.getOptions();
		int rbank= new Random().nextInt(options.size());
		select.selectByIndex(rbank);	
	}

public void clickOnSave() {
	WebElement savebtn= waitUtils.elementToBeClickable(driver, savebutton, 4);
	savebtn.click();
}
	
public void clickOnNext() {
	WebElement nextbtn= waitUtils.elementToBeClickable(driver, nextButton, 4);
	nextbtn.click();
}
	public void enterAllTheSubscriptionDetail() throws InterruptedException {
		
		selectSubscriptionPeriod();Thread.sleep(2000);
		selectSubscriptionType();Thread.sleep(2000);
		selectDeliveryMode();Thread.sleep(2000);
		selectSubscriptionStartMonth();Thread.sleep(2000);
		selectSubscriptionStartYear();Thread.sleep(2000);
		selectSubscriptionEndMonth();Thread.sleep(2000);
		selectSubscriptionEndYear();
		enterNoOfCopies();
		enterPaymentMode();
		EnterAmount();
		enterChequeDDUTRNo();
		selectPaymentDate();Thread.sleep(2000);
		selectBankName();Thread.sleep(2000);	
		clickOnSave();
		Thread.sleep(2000);
	}
	
	public  ICJ_UAT_ClaimsPage clickOnTheClaime() throws InterruptedException {
		System.out.println("1");
		enterAllTheSubscriptionDetail();
		System.out.println("2");
		Thread.sleep(2000);
		clickOnNext();	Thread.sleep(2000);	System.out.println("3");
		return new ICJ_UAT_ClaimsPage(driver);
	}
	
	
}

package com.pages.icj;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_ClaimsPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Select select;
	Random random;
	public ICJ_UAT_ClaimsPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
        configUtils.readConfig();
	}
	
	
	By issueclaimedmonth = By.xpath("//select[@formcontrolname='dd_issue_claim']");
	By issueclaimdyear = By.xpath("//select[@formcontrolname='dd_year']");
	By copysentby = By.xpath("//select[@formcontrolname='dd_sentBy']");
	By copysenton = By.xpath("//input[@formcontrolname='txt_sent_date']");
	By savebtnclick =By.xpath("//span[contains(text(),'Save')]");
	By clickonnext = By.xpath("//div[contains(text(),'Publication')]");
	
	public void selectIssueClaimedMonth() {
		WebElement claimmonth = waitUtils.waitForVisibility(driver, issueclaimedmonth, 4);	
		Select select = new Select(claimmonth);
		List<WebElement> options = select.getOptions();
		int randommonth = new Random().nextInt(options.size());
		select.selectByIndex(randommonth);
		
	}
	
	public void selectIssueClaimedYear() {
		WebElement claimyear= waitUtils.waitForVisibility(driver, issueclaimdyear, 4);
		Select select = new Select (claimyear);
		List<WebElement> options = select.getOptions();
		int randomyear = new Random().nextInt(options.size());
		select.selectByIndex(randomyear);
		}
	
	public void selectCopySentBy () {
		WebElement copysent = waitUtils.waitForVisibility(driver, copysentby, 4);
		Select select = new Select (copysent);
		List <WebElement> options = select.getOptions();
		int randomSentBy = new Random().nextInt(options.size());
		select.selectByIndex(randomSentBy);
	}
	public void selectCopySentOn() {
		random = new Random();
		int startYear = 2022;
		int endYear = 2023;

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
		String senton = formattedDay + "-" + formattedMonth + "-" + formattedYear;

		WebElement sentondate = waitUtils.waitForPresence(driver, copysenton, 4);
		sentondate.sendKeys(senton);
	}
	
	public void clickOnSave() {
		WebElement savebtn = waitUtils.waitForPresence(driver, savebtnclick, 4);
		savebtn.click();
	}
	
	public void clickOnTheNext() {
		WebElement clickbtn = waitUtils.waitForPresence(driver, clickonnext, 4);
		clickbtn.click();
	}
	public ICJ_UAT_PublicaitonPage enterAllTheClaimDetails () {
		System.out.println();
		selectIssueClaimedMonth();
		selectIssueClaimedYear();
		selectCopySentBy();
		selectCopySentOn();
		clickOnSave();
		clickOnTheNext();
		return new ICJ_UAT_PublicaitonPage(driver);
	}
	
	


}



package com.pages.icj;

import java.util.Random;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_PublicaitonPage {

	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Select select;
	Random random;

	public ICJ_UAT_PublicaitonPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
		configUtils.readConfig();
	}

	By currencytype = By.id("dd_currencyType");
	By cdname = By.xpath("//select[@formcontrolname='dd_cd_name']");
	By plussign = By.xpath("//img[@class='plus-icon']");
	By paymentmode = By.xpath("//select[@formcontrolname='dd_payment_mode']");
	By paymentdate = By.xpath("//select[@formcontrolname='dd_payment_date']");
	By chequeddutr = By.xpath("//select[@formcontrolname='txt_chequeDDUtr']");
	By bankname = By.xpath("//select[@formcontrolname='dd_bank']");
	By remove = By.xpath("//button[contains(text(),'Remove')]");
	By noofcopies = By.xpath("//select[@formcontrolname='txt_noOfCopies']");
	By savebtn = By.xpath("//span[contains(text(),'Save')]");
	By remark = By.xpath("//select[@formcontrolname='txt_remark']");
	By previousbtn = By.id("bt_previous");
	
	public void selectCurrencyType() {
		WebElement currtype = waitUtils.elementToBeClickable(driver, currencytype, 4);
		Select select = new Select(currtype);
		List<WebElement> options = select.getOptions();
		int randomcurrency = new Random().nextInt(options.size());
		select.selectByIndex(randomcurrency);

	}

	public void selectCDName() {
		WebElement cdn = waitUtils.elementToBeClickable(driver, cdname, 4);
		Select select = new Select(cdn);
		List<WebElement> options = select.getOptions();
		int randomcdname = new Random().nextInt(options.size());
		select.selectByIndex(randomcdname);
	}

	public void clickOnPlusSign() {
		WebElement plus = waitUtils.elementToBeClickable(driver, plussign, 4);
		plus.click();
	}

	public void selectPaymentMode() {
		WebElement paymo = waitUtils.elementToBeClickable(driver, paymentmode, 4);
		Select select = new Select(paymo);
		List<WebElement> options = select.getOptions();
		int randompayementmode = new Random().nextInt(options.size());

	}

	public void selectPaymentDate() {
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

		WebElement sentondate = waitUtils.waitForPresence(driver, paymentdate, 4);
		sentondate.sendKeys(senton);
	}

	public void enterchequeddutr() {
		WebElement chequeddutrs = waitUtils.waitForPresence(driver, chequeddutr, 4);
		long randomnumber = 1234567891234l + random.nextInt(123450438);
		String cheddutrno = String.valueOf(randomnumber);
		chequeddutrs.clear();
		chequeddutrs.sendKeys(cheddutrno);

	}

	public void selectBankName() {

		WebElement bank = waitUtils.waitForVisibility(driver, bankname, 4);
		select = new Select(bank);
		List<WebElement> options = select.getOptions();
		int rbank = new Random().nextInt(options.size());
		select.selectByIndex(rbank);
	}
	
	
	public void enterRemark() {
		WebElement remarkwrite= waitUtils.elementToBeClickable(driver, bankname, 4);
		remarkwrite.sendKeys("this is publication testing");
	}
	public void clickOnSave() {
		WebElement savebtncl = waitUtils.waitForPresence(driver, savebtn, 4);
		savebtncl.click();	
	}
	
	public void clickOnPrevious () {
		WebElement previousbtncl = waitUtils.waitForPresence(driver, previousbtn, 4);
		previousbtncl.click();
		
	}
	

}

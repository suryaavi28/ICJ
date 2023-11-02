package com.utilis;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;	

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public WebElement elementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public boolean waitForElementToBeSelected(WebDriver driver, By locator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
//	public void waitForPageToLoad(WebDriver driver) {
//	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    )
//	}

	public void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	public WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean waitForInvisibility(WebDriver driver, By locator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean waitForTextPresence(WebDriver driver, By locator, String text, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public boolean waitForTitleContains(WebDriver driver, String partialTitle, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
	
	public boolean waitForTitleIs(WebDriver driver, String title, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.titleIs(title));
	}

	public WebDriver waitForFrameAndSwitchToIt(WebDriver driver, By frameLocator, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));	 
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}


	public Alert waitForAlertDialog(WebDriver driver, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public boolean waitForElementSelectionState(WebDriver driver, By locator, boolean isSelected, int timeoutInSeconds) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, isSelected));
	}


	
	

}

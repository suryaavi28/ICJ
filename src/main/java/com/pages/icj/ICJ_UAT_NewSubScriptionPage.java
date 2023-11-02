package com.pages.icj;	
	
import java.util.List;	
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilis.ReadConfigUtilities;
import com.utilis.WaitUtilities;

public class ICJ_UAT_NewSubScriptionPage {
	WebDriver driver;
	WaitUtilities waitUtils;
	static ReadConfigUtilities configUtils;
	Random random;
	int retryCount = 0;

	public ICJ_UAT_NewSubScriptionPage(WebDriver driver) {
		waitUtils = new WaitUtilities();
		this.driver = driver;
		configUtils = new ReadConfigUtilities(); // Initialize the configUtils instance
		configUtils.readConfig();

	}

	private By customertype = By.id("dd_customerType");
	private By categoryforsubscriber = By.id("dd_categorySubscriber");
	private By title = By.id("dd_title");
	private By firstname = By.id("txt_firstName");
	private By lastname = By.id("txt_lastname");
	private By designation = By.id("txt_designation");
	private By department = By.id("txt_department");
	private By collegecompany = By.id("txt_company");
	private By pincode = By.id("txt_pincode");
	private By address = By.id("txt_address");
	private By city = By.id("txt_city");
	private By state = By.id("dd_state");
	private By country = By.id("dd_state");
	private By phone = By.id("txt_phone");
	private By mobile = By.id("txt_mobile");
	private By email = By.id("txt_email");
	private By alternateemail = By.id("txt_alternate_email");
	private By dob = By.id("txt_dob");
	private By agencyname = By.id("txt_agency_name");
	private By agentcode = By.id("txt_agent_code");
	private By status = By.id("dd_status");
	private By renewal = By.id("txt_next_renewal");
	private By submit = By.xpath("//button[normalize-space()='Save']");
	private By newidclick = By.xpath("//tbody/tr[1]/td[2]//a");
	private By SubscriptionDetailnew = By.xpath("//div[contains(text(),'Subscription Detail')]");
	private By vcustomertype = By.id("dd_customerType_error");
	private By vcategoryforcustomer = By.id("dd_categorySubscriber_error");
	private By vtitle = By.id("dd_title_error");
	private By vfirstname = By.xpath("//span[normalize-space()='First Name is required']");
	private By vpincode = By.xpath("//span[normalize-space()='Pincode is required']");
	private By vaddress = By.xpath("//span[normalize-space()='Address is required']");
	private By vcity = By.xpath("//span[normalize-space()='Address is required']");
	private By vstate = By.xpath("//span[normalize-space()='Address is required']");
	private By vcountry = By.xpath("//span[normalize-space()='Country is required']");
	private By vmobile = By.xpath("//span[normalize-space()='Mobile is required']");

	private boolean vcustIsDisplayed=false;
//	
//	public void validationCustomerType() {
//		try {
//			WebElement vcust = waitUtils.waitForPresence(driver, vcustomertype, 1);
//			 vcustIsDisplayed = vcust.isDisplayed();
////			if (retryCount < 4) {
////				while (vcustIsDisplayed == true) {
////					selectCustpmertype();
////					vcustIsDisplayed = vcust.isDisplayed();
////					retryCount++;
////				}
////			}
//			if (vcustIsDisplayed==true) {
//				selectCustpmertype();
//			}
//		} catch (Exception e) {
//
//		}
//	}

	public void selectCustpmertype() {
		try {
			WebElement custype = waitUtils.waitForVisibility(driver, customertype, 4);	
			Select select = new Select(custype);
			List<WebElement> options = select.getOptions();
			int randomIndex = new Random().nextInt(options.size());
			select.selectByIndex(randomIndex);
			vcustIsDisplayed=false;
		} catch (Exception e) {

		}
	}

//	public void validationCategoryFOrSubscriber() {
//		try {
//			WebElement vcustcate = waitUtils.waitForPresence(driver, vcategoryforcustomer, 1);
//			boolean vcustIsDisplayed = vcustcate.isDisplayed();
//			if (vcustIsDisplayed == true) {
//				//while (vcustIsDisplayed == true) {
//					selectCategoryFOrSubscriber();
//				//	vcustIsDisplayed = vcustcate.isDisplayed();
//				//	retryCount++;
//				}
//			
//		} catch (Exception e) {
//
//		}
//	}

	public void selectCategoryFOrSubscriber() {
		try {
			WebElement category = waitUtils.waitForVisibility(driver, categoryforsubscriber, 4);
			Select select = new Select(category);
			List<WebElement> options = select.getOptions();
			int randomIndex = new Random().nextInt(options.size());
			select.selectByIndex(randomIndex);
		} catch (Exception e) {
			System.out.println("taking another chance sub");
		}
	}

//	public void validationTitle() {
//		try {
//			WebElement vcusttitle = waitUtils.waitForPresence(driver, vtitle, 4);
//			boolean vcustIsDisplayed = vcusttitle.isDisplayed();
//			if (vcustIsDisplayed == true) {
//				//while (vcustIsDisplayed == true) {
//					selectTitle();
//				//	vcustIsDisplayed = vcusttitle.isDisplayed();
//				//	retryCount++;
//				}
//			
//		} catch (Exception e) {
//
//		}
//	}

	public void selectTitle() {
		try {
			WebElement titleOfName = waitUtils.elementToBeClickable(driver, title, 4);
			Select select = new Select(titleOfName);
			List<WebElement> options = select.getOptions();
			int randomIndex = new Random().nextInt(options.size());
			select.selectByIndex(randomIndex);
		} catch (Exception e) {
			System.out.println("taking another chance title ");
		}

	}

	public void enterFirstName() {
		WebElement name = waitUtils.waitForPresence(driver, firstname, 4);
		String[] firstNames = { "Rajesh", "Priya", "Amit", "Deepika", "Sanjay", "Neha", "Vikram", "Pooja", "Rahul",
				"Anita", "Vishal", "Sneha" };
		random = new Random();
		String rfirstName = firstNames[random.nextInt(firstNames.length)];

		name.sendKeys(rfirstName);
	}

	public void enterLastName() {
		WebElement name = waitUtils.waitForPresence(driver, lastname, 4);
		String[] lastNames = { "Sharma", "Verma", "Patel", "Gupta", "Singh", "Kumar", "Yadav", "Mishra", "Jain",
				"Chauhan", "Reddy", "Rao", "Das", "Nair" };
		random = new Random();
		String rlastName = lastNames[random.nextInt(lastNames.length)];

		name.sendKeys(rlastName);
	}

	public void enterDesignation() {
		WebElement desi = waitUtils.waitForPresence(driver, designation, 4);
		String[] Designations = { "Manager", "Software Engineer", "Accountant", "Project Manager", "HR Specialist",
				"Marketing Coordinator", "Sales Executive", "Data Analyst", "Customer Support Representative",
				"Operations Manager", "Graphic Designer", "Product Manager", "Financial Analyst", "Executive Assistant",
				"Quality Assurance Engineer", "Business Analyst", "Network Administrator", "UX Designer",
				"Legal Counsel", "Research Scientist" };
		random = new Random();
		String rdesignation = Designations[random.nextInt(Designations.length)];

		desi.sendKeys(rdesignation);
	}

	public void enterDepartment() {
		WebElement depart = waitUtils.waitForPresence(driver, department, 4);
		String[] Departments = { "Human Resources", "Engineering", "Finance", "Marketing", "Sales", "IT Support",
				"Customer Service", "Research and Development", "Quality Assurance", "Operations", "Legal", "Design",
				"Product Management", "Supply Chain", "Administration" };
		random = new Random();
		String rdepartment = Departments[random.nextInt(Departments.length)];

		depart.sendKeys(rdepartment);
	}

	public void enterCollegeCompany() {
		WebElement college = waitUtils.waitForPresence(driver, collegecompany, 4);
		String[] CollegeCompanies = { "DAV", "Menon", "D.Y. Patil", "National College", "Sanghi", "ACC", "Ambuja",
				"Wow", "Adani Enterprises", "JP Cement" };
		random = new Random();
		String rdepartment = CollegeCompanies[random.nextInt(CollegeCompanies.length)];

		college.sendKeys(rdepartment);
	}

	public void enterPinCOde() {
		random = new Random();
		int randomPinCode = 400000 + random.nextInt(100000);
		String pinCodeString = String.valueOf(randomPinCode);
		WebElement pin = waitUtils.waitForPresence(driver, pincode, 4);
		pin.clear();
		pin.sendKeys(pinCodeString);
	}

	public void validationAddress() {
		try {
			WebElement vaddresses = waitUtils.waitForPresence(driver, vaddress, 4);
			boolean vcustIsDisplayed = vaddresses.isDisplayed();
			while (retryCount < 4) {
				while (vcustIsDisplayed == true) {
					enteraddress();

					vcustIsDisplayed = vaddresses.isDisplayed();
					retryCount++;
				}
			}
		} catch (Exception e) {
			System.out.println("not getting");
		}
	}

	public void enteraddress() {
		try {
			WebElement add = waitUtils.waitForPresence(driver, address, 4);
			String[] Addresses = { "Mumbai, Maharashtra", "Delhi, National Capital Territory of Delhi",
					"Bangalore, Karnataka", "Hyderabad, Telangana", "Chennai, Tamil Nadu", "Kolkata, West Bengal",
					"Pune, Maharashtra", "Ahmedabad, Gujarat", "Jaipur, Rajasthan", "Lucknow, Uttar Pradesh" };
			random = new Random();
			String raddress = Addresses[random.nextInt(Addresses.length)];
			add.sendKeys(raddress);
		} catch (Exception e) {
			System.out.println("taking another chance address");
		}

	}

	public void validationCity() {
		try {
			WebElement vcitiess = waitUtils.waitForPresence(driver, vcity, 4);
			boolean vcustIsDisplayed = vcitiess.isDisplayed();
			while (retryCount < 4) {
				while (vcustIsDisplayed == true) {
					selectcity();

					vcustIsDisplayed = vcitiess.isDisplayed();
					retryCount++;
				}
			}
		} catch (Exception e) {
			System.out.println("taking another chance city");
		}
	}

	public void selectcity() {
		try {
			WebElement cities = waitUtils.waitForVisibility(driver, city, 10);
//		Select select = new Select(cities);
//		List<WebElement> options = select.getOptions();
//		int randomIndex = random.nextInt(options.size());
//		select.selectByIndex(randomIndex);

			String[] citiesName = { "Alipur", "Andaman Island", "Arainj-Laka-Punga", "Calicut", "Brookesabad",
					"Herbertabad", "Inteview Island", "Kartara", "Maimyo", "North Brother Island",
					"North Passage Island", "North Sentinel Island", "Nothen Reef Island", "Nothen Reef Island",
					"Nothen Reef Island", "Nothen Reef Island", "Rutland Island", "Shadipur", "South Sentinel Island",
					"Tarmugli Island", "West Island", "Adilabad", "Alur", "Anantapur" };
			random = new Random();
			String rcities = citiesName[random.nextInt(citiesName.length)];

			cities.sendKeys(rcities);
		} catch (Exception e) {
			System.out.println("not getting another chance");
		}

	}

	public void enterPhoneNumber() {
		random = new Random();
		long randomPinCode = 25600000000l + random.nextInt(1000000);
		String phonenumber = String.valueOf(randomPinCode);
		WebElement phonno = waitUtils.waitForPresence(driver, phone, 4);
		phonno.clear();
		phonno.sendKeys(phonenumber);
	}

	public void enterMobileNumber() {
		random = new Random();
		long randmob = 9821000000l + random.nextInt(1000000);
		String mobnumber = String.valueOf(randmob);
		WebElement mobno = waitUtils.waitForPresence(driver, mobile, 4);
		mobno.clear();
		mobno.sendKeys(mobnumber);
	}

	public void enterEmailAddress() {
		String[] domains = { "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com" };
		random = new Random();
		String[] userName = { "John", "Mary", "David", "Sarah", "Michael", "Jennifer", "William", "Linda", "Richard",
				"Elizabeth", "James", "Susan", "Robert", "Karen", "Joseph", "Patricia", "Thomas", "Nancy", "Daniel",
				"Lisa" };
		String randomemailadd = userName[random.nextInt(userName.length)] + domains[random.nextInt(domains.length)];
		WebElement emailid = waitUtils.waitForPresence(driver, email, 4);
		emailid.sendKeys(randomemailadd);

	}

	public void enterAlternateEmailAddress() {
		String[] domains = { "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com" };
		random = new Random();
		String[] userName = { "John", "Mary", "David", "Sarah", "Michael", "Jennifer", "William", "Linda", "Richard",
				"Elizabeth", "James", "Susan", "Robert", "Karen", "Joseph", "Patricia", "Thomas", "Nancy", "Daniel",
				"Lisa" };
		String randomalternateemailadd = userName[random.nextInt(userName.length)]
				+ domains[random.nextInt(domains.length)];
		WebElement emailid = waitUtils.waitForPresence(driver, alternateemail, 4);
		emailid.sendKeys(randomalternateemailadd);

	}

	public void selectBirthDate() {
		random = new Random();
		int startYear = 1950;
		int endYear = 2010;

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
		String birthdate = formattedDay + "-" + formattedMonth + "-" + formattedYear;

		WebElement birthday = waitUtils.waitForPresence(driver, dob, 4);
		birthday.sendKeys(birthdate);
	}

	public void clickOnSubmit() {
		WebElement submitbtn = waitUtils.elementToBeClickable(driver, submit, 10);
		submitbtn.click();
	}

	public void ValidationMessageAndSubmit() {

	}

	public void verifyWithAllTheDetails() throws InterruptedException {
		
		selectCustpmertype();

		selectCategoryFOrSubscriber();

		selectTitle();

		enterFirstName();

		enterLastName();

		enterDesignation();

		enterDepartment();

		enterCollegeCompany();

		enterPinCOde();

		enteraddress();
		Thread.sleep(1000);
		selectcity();

		enterPhoneNumber();

		enterMobileNumber();

		enterEmailAddress();

		enterAlternateEmailAddress();

		selectBirthDate();
		
		
		clickOnSubmit();
		
		
		 try {
		        WebElement vcustypes = driver.findElement(vcustomertype);
		        if (vcustypes.isDisplayed()) {
		            selectCustpmertype();
		        }
		    } catch (NoSuchElementException e) {
		        // Element not found, no action needed
		    }

		    try {
		        WebElement vcateforsub = driver.findElement(vcategoryforcustomer);
		        if (vcateforsub.isDisplayed()) {
		            selectCategoryFOrSubscriber();
		        }
		    } catch (NoSuchElementException e) {
		        // Element not found, no action needed
		    }

		    try {
		        WebElement vtitledis = driver.findElement(vtitle);
		        if (vtitledis.isDisplayed()) {
		            selectTitle();
		        }
		    } catch (NoSuchElementException e) {}
		        // Element not found, no action needed
		     try {WebElement vsubmit = driver.findElement(submit);
		    if (vsubmit.isDisplayed()) {
		    	clickOnSubmit();
		    }}
		catch  (NoSuchElementException e)  {
	}
	}
	public ICJ_UAT_SubscriptionDetailPage enternewsubscriptionandenterSubscriptionDetail() throws InterruptedException {
		verifyWithAllTheDetails();
		WebElement subscriberfirst = waitUtils.elementToBeClickable(driver, newidclick, 10);
		subscriberfirst.click();
		WebElement subscriberDetailclick = waitUtils.elementToBeClickable(driver, SubscriptionDetailnew, 10);
		subscriberDetailclick.click();
		return new ICJ_UAT_SubscriptionDetailPage(driver);
	}
	public void validateErrorMessage() throws InterruptedException {
		clickOnSubmit();
		Thread.sleep(20000);
	}
	
	

}

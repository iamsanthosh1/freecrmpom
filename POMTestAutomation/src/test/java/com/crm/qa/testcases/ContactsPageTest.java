package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName="contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.clickOnContactslink();
	}
	
	@Test(priority=1)
	public void verifycontactspagelabel() {
		Assert.assertTrue(contactspage.verifycontactslabel() , "contacts label is missing on the page");
	}

	@DataProvider
	public Object[][] getCrmTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2 , dataProvider="getCrmTestData")
	public void validatecreatNewContact(String firstname,String lastname,String company) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("shaik", "Ayan", "Finance");
		contactspage.createNewContact(firstname, lastname, company);
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}

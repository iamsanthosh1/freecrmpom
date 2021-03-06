package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase{
	
@FindBy(xpath="//span[@class='user-display']")
WebElement userlabel;

@FindBy(css="#main-nav>a:nth-child(3)")
WebElement contactslink;
@FindBy(xpath="//button[contains(text(),'New')]")
WebElement NewContactLink;

@FindBy(css="#main-nav>a:nth-child(5)")
WebElement Dealslink;
@FindBy(xpath="//button[contains(text(),'New')]")
WebElement NewDealsLink;

@FindBy(css="#main-nav>a:nth-child(6)")
WebElement tasklink;
@FindBy(xpath="//button[contains(text(),'New')]")
WebElement NewTaskLink;

public HomePage() {
	PageFactory.initElements(driver, this);
}

public String  verifyHomePageTitle() {
	return driver.getTitle();
}
public boolean verifyuserlabel() {
	return userlabel.isDisplayed();
}


public ContactsPage clickOnContactslink() {
	contactslink.click();
	return new ContactsPage();
}
public void clickOnNewContactsLink() {
	contactslink.click();
	NewContactLink.click();
}


public DealsPage clickOnDealslink() {
	Dealslink.click();
	return new DealsPage();
}
public void clickOnNewDealsLink() {
	Dealslink.click();
	NewDealsLink.click();
}


public TaskPage clickOnTasklink() {
	tasklink.click();
	return new TaskPage();
}
public void clickOnNewTaskLink() {
	tasklink.click();
	NewTaskLink.click();
	
}
}

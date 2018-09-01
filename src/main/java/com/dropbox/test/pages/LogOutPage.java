package com.dropbox.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.test.base.BaseClass;
import com.dropbox.test.utils.TestUtils;

public class LogOutPage extends BaseClass{
	
	TestUtils testUtils = new TestUtils();
	
	@FindBy(xpath = "//div[@class='mc-avatar']/img")
	WebElement logoutAvatar;
	
	@FindBy(linkText = "Sign out")
	WebElement signOutLink;
	
	public LogOutPage(){
		PageFactory.initElements(driver, this);
	}
	
	public LogOutPage logoutFunction(){
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(logoutAvatar));
		logoutAvatar.click();
		TestUtils.implicityWait();
		signOutLink.click();
		
		return new LogOutPage();
	}

}

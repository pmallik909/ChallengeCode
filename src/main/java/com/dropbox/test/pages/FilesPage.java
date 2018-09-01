package com.dropbox.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dropbox.test.base.BaseClass;

public class FilesPage extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	//@FindBy(xpath = "//a[@href='https://www.dropbox.com/home' and @class='maestro-nav__product']")
	@FindBy(xpath = "//div[@class='maestro-nav__container']/div/div/ul/li//a[contains(text(),'Files')]")
	WebElement filesLink;
	
	@FindBy(xpath = "//div[@class='appactions-menu--buttons']/ul/li/button[@class='mc-tertiary-link-button secondary-action-menu__button action-new-folder']")
	WebElement newFolderLink;
	
	@FindBy(xpath = "//input[@class='c-input']")
	WebElement folderNameInputBox;
	
	@FindBy(xpath = "//a[contains(text(),'uploadFile')]/parent::div/parent::div/following-sibling::div//button")
	WebElement uploadFileDeleteButtonIcon;
	
	@FindBy(xpath = "//a[contains(text(),'uploadFile')]/parent::div/parent::div/following-sibling::div//button/following-sibling::div//div/button[contains(text(),'Delete')]")
	WebElement uploadFileDeleteButton;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement deleteButton;
	
	@FindBy(id = "notify")
	WebElement deleteNotifyMessage;
	
	@FindBy(xpath = "//spn[contains(text(), 'New Folder")
	WebElement newFolder;
	
	public FilesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void waitForPresenceOfElement(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://www.dropbox.com/home' and @class='maestro-nav__product']")));
	}

	public FilesPage clickOnFilesLink(){			
		
		wait.until(ExpectedConditions.stalenessOf(filesLink));
		waitForPresenceOfElement();
		JavascriptExecutor jsExecute = (JavascriptExecutor)driver;
		jsExecute.executeScript("arguments[0].click();", filesLink);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		return new FilesPage();			
	}
	
	public FilesPage clickOnNewFolderLink(){
		
		wait.until(ExpectedConditions.elementToBeClickable(newFolderLink));
		newFolderLink.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		folderNameInputBox.sendKeys(properties.getProperty("folderName"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		folderNameInputBox.sendKeys(Keys.ENTER);	
		//wait.until(ExpectedConditions.visibilityOf(newFolder));
		
		
		return new FilesPage();		
	}
	
	public FilesPage deleteUploadedFile(){
		
		wait.until(ExpectedConditions.elementToBeClickable(uploadFileDeleteButtonIcon));
		uploadFileDeleteButtonIcon.click();
		wait.until(ExpectedConditions.elementToBeClickable(uploadFileDeleteButton));
		uploadFileDeleteButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
		deleteButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteNotifyMessage));
				
		return new FilesPage();		
	}
	
	
	
}

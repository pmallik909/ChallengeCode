package com.test.qa.dropbox.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dropbox.test.base.BaseClass;
import com.dropbox.test.pages.FilesPage;
import com.dropbox.test.pages.HomePage;
import com.dropbox.test.pages.LandingPage;
import com.dropbox.test.pages.LogOutPage;
import com.dropbox.test.utils.TestUtils;

public class TestCases extends BaseClass{
	
	//Pages to be interacted while Test is Executed - initialized
	LandingPage landingPage;
	HomePage homePage;
	LogOutPage logoutPage;
	FilesPage filePage;	
	
	
	public TestCases(){
		super();
	}
	
	
	@BeforeTest(description = "Initialize The Browser Launch Operation")
	public void browserLaunch() {
		
		initializeTest();
		landingPage = new LandingPage();
		homePage = new HomePage();
		logoutPage = new LogOutPage();
		filePage = new FilesPage();
				
	}
	
	
	@Parameters({"email","password"})
	@BeforeMethod(description = "Perfomm Login Operation Before Each Test")
	public void login(String email, String password){
		
		TestUtils.implicityWait();
		landingPage.login(email, password);
		TestUtils.implicityWait();
		
	}
	
	@Test(priority = 1,successPercentage = 100, description = "Home Page Validation", enabled = true)
	public void loginValidation() {
		
		TestUtils.implicityWait();
		
		homePage.homePageElementVisbility();		
		String homePageTitle = landingPage.getPageTitle();
		Assert.assertEquals(homePageTitle, TestUtils.pageTitle);
		
	}
	
	@Test(priority = 2,successPercentage = 100, description = "Upload a New File", enabled = true)
	public void fileUploadTest() throws AWTException, InterruptedException {
		
		TestUtils.implicityWait();
		homePage.uploadFile();
		TestUtils.implicityWait();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 3,successPercentage = 100, description = "Search For the Uploaded File", enabled = true)
	public void searchUploadedFileTestCase(){		
		
		TestUtils.implicityWait();
		homePage.searchFile();
		
		
	}
	
	@Test(priority = 4,successPercentage = 100, description = "Delete Uplaoded File", enabled = true)
	public void deleteUploadedFile(){
		
		TestUtils.implicityWait();
		filePage.deleteUploadedFile();
		
	}
		
	
	@Test(priority = 5,successPercentage = 100, description = "Create a New Folder", enabled = true)
	public void createFolderTest() throws InterruptedException{		
		
		TestUtils.implicityWait();
		filePage.clickOnFilesLink();
		TestUtils.implicityWait();
		filePage.clickOnNewFolderLink();
		TestUtils.implicityWait();
		//Thread.sleep(3000);
		
	}
	
	
	
	@AfterMethod(description = "LogOut From the Test Case")
	public void logoutTest(){
		
		logoutPage.logoutFunction();
	}
	
	@AfterTest(description = "Close The Browser")
	public void closeTest(){
		
		closeBrowser();
		
	}
}

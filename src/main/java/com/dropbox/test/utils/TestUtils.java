package com.dropbox.test.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dropbox.test.base.BaseClass;

public class TestUtils extends BaseClass{
	
	
	public static final String pageTitle = "Home - Dropbox";
	
	
	
	public static void takeScreenShot() throws IOException{
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDirectory = System.getProperty("user.dir");
		
		FileUtils.copyFile(sourceFile, new File(currentDirectory+ "/screenshots"+System.currentTimeMillis() + ".png"));
		
	}
	
	
	public static void implicityWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void setFileLocation(String string) {
		
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	
	
	public void uploadAction(String fileLocation) throws AWTException, InterruptedException{
		
		setFileLocation(fileLocation);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
}

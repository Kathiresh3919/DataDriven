package com.vcentry.tnstc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.tnstc.initializer.Initializer;
import com.vcentry.tnstc.inputreader.inputReader;
import com.vcentry.tnstc.pages.RegPage;
import com.vcentry.tnstc.reportGenerator.ScreenshotGenerator;



public class RegPageTest extends Initializer{
	@Test(dataProvider="RegPageTest")
	public void validateRegpage(String tcName,String username,String password,String confirmpassword,String SQ, String SA) throws IOException{
		initialize();
		log=reports.startTest(tcName+" Initiated");
		wd.get(envprop.getProperty("URL"));
		/*wd.get(envprop.getProperty("URL"));
		WebElement username = wd.findElement(By.name("txtUserLoginID"));
		username.sendKeys("Kathiresh Kumar");
		WebElement password = wd.findElement(By.name("txtPassword"));
		password.sendKeys("kathir3919");
		WebElement confpassword = wd.findElement(By.name("txtConfirmPassword"));
		confpassword.sendKeys("kathir3919");
		WebElement secretq= wd.findElement(By.name("txtSecretQuestion"));
		Select s = new Select(secretq);
		s.selectByIndex(5);
		WebElement anssecq= wd.findElement(By.name("txtSecretAnswer"));
		anssecq.sendKeys("RMK");*/
		
		/*wd.get(envprop.getProperty("URL"));
		wd.findElement(By.name(locatorprop.getProperty("REGPAGE_TYPE_USERNAME_NAME")));
		wd.get(locatorprop.getProperty("REGPAGE_TYPE_PASSWORD_NAME"));
		wd.get(locatorprop.getProperty("REGPAGE_TYPE_CONFIRMPASSWORD_NAME"));*/
		
		
		/*getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys("ABC");
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys("123");
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys("123");
		WebElement dropdown=getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		Select s = new Select(dropdown);
		s.selectByIndex(5);
		getElementByName("REGPAGE_TYPE_ANSWERSECRETQUESTION_NAME").sendKeys("RMK");*/
		
		RegPage.enterUsername(username);
		RegPage.enterPassword(password);
		RegPage.enterConfirmpassword(confirmpassword);
		RegPage.selectSecretquestion(SQ);
		RegPage.enterSecretanswer(SA);
	}
	@DataProvider(name="RegPageTest")
	public static Object[][] getData() throws Exception{
		if(inputReader.RunModeVerification("RegPageTest")){
		Object[][] data=inputReader.selectSingleDataOrMulitiData("RegPageTest");
				return data;
		}
		return null;
	}
	 @AfterMethod
     public void teardown(ITestResult it) throws IOException{
    	ScreenshotGenerator.generatorScreenshot(it);
     }
	
	

}

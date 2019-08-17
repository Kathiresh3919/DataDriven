package com.vcentry.tnstc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vcentry.tnstc.initializer.Initializer;

public class RegPage extends Initializer{
	public static void enterUsername(String username){
		getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys(username);
	}
	public static void enterPassword(String password){
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys(password);
	}
	public static void enterConfirmpassword(String confirmpassword){
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys(confirmpassword);
	}
	public static void selectSecretquestion(String SQ){
		WebElement dropdown=getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		Select s = new Select(dropdown);
		s.selectByVisibleText(SQ);
	}
	public static void enterSecretanswer(String SA){
		getElementByName("REGPAGE_TYPE_ANSWERSECRETQUESTION_NAME").sendKeys(SA);
	}

}

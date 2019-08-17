package com.vcentry.tnstc.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.tnstc.reportGenerator.ReportOptimizer;

public class Initializer {
	/**
	 * Report variables
	 */
	public static ExtentReports reports;
	public static ExtentTest log;
	/**
	 * @author ke20
	 * declare environment variables
	 */
	public static FileInputStream envfis=null;
	public static Properties envprop=null;
	/**
	 * @author ke20
	 * declare locator variable
	 */
	public static FileInputStream locatorfis=null;
	public static Properties locatorprop=null;
	/**
	 * @author ke20
	 * declare webdriver variable
	 */
	public static WebDriver wd=null;
	public static boolean isReportExist=true;
	public static void initialize() throws IOException{
		if(isReportExist){
			ReportOptimizer.optimizeReport();
		reports=new ExtentReports("C:\\Users\\ke20\\workspace\\DDDTest\\Reports\\report.html");
		isReportExist=false;
		}
		//File f=new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties");
		//FileInputStream envfis=new FileInputStream(f);
		
		envfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties"));
		envprop=new Properties();
		envprop.load(envfis);
		
		locatorfis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"locator.properties"));
		locatorprop=new Properties();
		locatorprop.load(locatorfis);
		
		if(wd==null){
		if(envprop.getProperty("BROWSER").equals("FIREFOX")){
			wd=new FirefoxDriver();
			
		}
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//wd.manage().deleteAllCookies();
		
	}
	public static WebElement getElementByName(String name){
		return wd.findElement(By.name(locatorprop.getProperty(name)));
		
	}
	

}

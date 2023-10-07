package com.trello.sustine.Generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility webdriverUtils = new WebDriverUtility();
	public JavaUtility javaUtils = new JavaUtility();
	public FileUtility fileUtils = new FileUtility();
	
	@BeforeClass
	public void executeBeforeClass () throws IOException {
		String browser = fileUtils.readDataFromPropertyFile("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webdriverUtils.implicitWait(driver);
		driver.get(fileUtils.readDataFromPropertyFile("url"));
	}
	
	@AfterClass
    public void executeAfterClass () {
	driver.manage().window().minimize();
	driver.quit();
}

}

package com.enumerations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.enumerations.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver driver;
	
	public DriverManager(BrowserType browser) {
		switch(browser) {
		case Chrome:
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		case Firefox:
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			break;
		case InternetExplorer:
			WebDriverManager.iedriver().setup();
			this.driver = new InternetExplorerDriver();
			break;
		}
		
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	

}

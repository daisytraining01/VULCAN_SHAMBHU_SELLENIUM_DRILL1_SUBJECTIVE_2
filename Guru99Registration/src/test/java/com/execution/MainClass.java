package com.execution;


import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.helper.*;
import com.enumerations.BrowserType;



public class MainClass extends UserActions {
	static WebDriver driver;
	 static String firstName;
	 static String lastName;
	 static String phone;static String emailId;static String address; static String city;
		static String state; static String postalCode; static String country; static String userName; static String pass;
	public MainClass(String firstName, String lastName, String phone, String emailId, String address, String city,
			String state, String postalCode, String country, String userName, String pass) {
this.firstName=firstName;
this.lastName=lastName;
this.phone=phone;
this.emailId=emailId;
this.address=address;
this.city=city;
this.state=state;
this.postalCode=postalCode;
this.country=country;
this.userName=userName;
this.pass=pass;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		MainClass m=new MainClass("shambh", "raj", "6543987456", "abc@gmail.com", "Mogappair", "Chennai", "Tamilnadu", "6000034", "AUSTRALIA", "sham", "4321");
		LaunchBrowser(BrowserType.Chrome);
		OpenUrl("http://demo.guru99.com/test/newtours/register.php");
		
		SendKeys(RegistrationPage.firstName, firstName);
		SendKeys(RegistrationPage.lastName, lastName);
		SendKeys(RegistrationPage.phone, phone);
		SendKeys(RegistrationPage.email, emailId);
		SendKeys(RegistrationPage.address, address);
		SendKeys(RegistrationPage.city, city);
		SendKeys(RegistrationPage.state, state);
		SendKeys(RegistrationPage.postalCode, postalCode);
		SelectByVisible_Text(RegistrationPage.country, country);
		List<WebElement> countrulist = get_AllValue_Dropdown(RegistrationPage.country);
		Set<String> set=new HashSet<String>();
		for (WebElement str : countrulist) {
			set.add(str.getText());
		}
		SendKeys(RegistrationPage.userName, userName);
		SendKeys(RegistrationPage.password, pass);
		SendKeys(RegistrationPage.confirmPassword, pass);
		System.out.println("Country List Name : "+set);
		click(RegistrationPage.submit);
		//register_sucess.php
		Thread.sleep(5000);
		Assert.assertEquals(true, getCurrentUrl().contains("register_sucess"));
		CaptureScreenshot();
		quitBrowser();
		System.out.println("Done...........");

	}

}

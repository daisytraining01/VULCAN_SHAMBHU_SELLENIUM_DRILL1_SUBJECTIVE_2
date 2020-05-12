package com.link;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Link Size : " + links.size());
		System.out.println("All links are: ");
		for (WebElement webElement : links) {
			System.out.println(webElement.getAttribute("href"));
		}

	}

}

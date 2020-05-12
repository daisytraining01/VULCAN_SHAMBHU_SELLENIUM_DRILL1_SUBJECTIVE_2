package com.exception;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionsClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");

		List<WebElement> newWindow = driver.findElements(By.name("firstName"));
		if (newWindow.size() != 0) {
			newWindow.get(0).sendKeys("shambhu");
		} else {
			System.out.println("NoSuchElementException");
		}
		List<WebElement> lastName = driver.findElements(By.tagName("a"));
		if (lastName.size() > 0) {
			System.out.println("Size : " + lastName.size());
		} else {
			System.out.println("ArrayIndexOfBoundException");
		}

		List<WebElement> frame = driver.findElements(By.id("phone"));
		if (frame.size() != 0) {
			driver.switchTo().frame(1);
		} else {
			System.out.println("NoSuchFrameException");
		}

		Set<String> Windows = driver.getWindowHandles();

		if (Windows.size() > 0) {
			for (String win : Windows) {
				String parWindow = driver.getWindowHandle();
				if (!Windows.equals(parWindow)) {
					driver.switchTo().window(win);
				} else {
					System.out.println("NoSuchWindowException");
				}
			}

		}
	}
}

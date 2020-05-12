package com.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;
import com.enumerations.BrowserType;
import com.enumerations.DriverManager;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserActions {
	Set<String> set = new HashSet<String>();


	static WebDriver driver;

	public static void LaunchBrowser(BrowserType browser) {
		driver = new DriverManager(browser).getDriver();
	}

	public static void OpenUrl(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void CaptureScreenshot() throws IOException {
		try {
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path="C:\\Users\\SHAMBHU\\eclipse-workspace\\CucumberFramework\\Guru99Registration\\ScreenShot\\Snap"+date+".png";
			File f = new File(path);
			//System.out.println(f);
			FileUtils.copyFile(screenshot, f);
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean isDisplayed(By Locator) {
		return driver.findElement(Locator).isDisplayed();
	}

	public boolean isEnabled(By Locator) {
		return driver.findElement(Locator).isEnabled();
	}

	public boolean isSelected(By Locator) {
		return driver.findElement(Locator).isSelected();
	}

	public static void click(By Locator) {
		driver.findElement(Locator).click();
	}
public static String getTitle() {
	return driver.getTitle();

}
public static String getCurrentUrl() {
	return driver.getCurrentUrl();

}
	// Shambhu
	public static void SelectByVisible_Text(By Locator, String text) {
		WebElement element = driver.findElement(Locator);
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	public static List<WebElement> get_AllValue_Dropdown(By Locator) {
		List<WebElement> element = driver.findElements(Locator);
		return element;
	}

	public static void SendKeys(By Locator, String text) {
		driver.findElement(Locator).sendKeys(text);
	}
	public static String get_Text() {
		return driver.findElement(By.xpath("//*[@href='login.php']")).getAttribute("href");
	}

	public void ClearAndSendKeys(By Locator, String Text) {
		driver.findElement(Locator).click();
		driver.findElement(Locator).clear();
		driver.findElement(Locator).sendKeys(Text);
	}

	public void WaitAndClick(By Locator, int TimeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
	}

	public void WaitAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.sendKeys(Text);
	}

	public void WaitClearAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.clear();
		ele.sendKeys(Text);
	}

	public static void quitBrowser() {
		driver.quit();

	}

}

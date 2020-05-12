package com.helper;

import org.openqa.selenium.By;

public class ObjectHelper {
	
	protected static By InputBox_Below_Label(String fieldName) {
		return By.xpath("//*[.='"+fieldName+"']/following::input[1]");
	}
	protected static By Button(String fieldName) {
		return By.xpath("//input[@class='button' and @value='"+fieldName+"']");
	}
	//========================================================================================
	//created by shambhu
	protected static By InputBox_Below_Label_Name(String fieldName) {
		return By.name(fieldName);
	}
	protected static By InputBox_Below_Label_Id(String fieldName) {
		return By.id(fieldName);
	}
	protected static By Button_By_Text(String fieldName) {
		return By.xpath("//*[.='"+fieldName+"']");
	}
	protected static By InputBox_Below_Label_Xpath(String fieldName) {
		return By.xpath("//*[.='"+fieldName+"']/following::input[1]");
	}
	
	protected static By Select_Box_Below_Label_Id(String fieldName) {
		return By.id(fieldName);
	}
	protected static By Select_Link_By_LinkText(String linkText) {
		return By.linkText(linkText);
	}
	protected static By Click_By_Class(String fieldName) {
		return By.xpath("//*[@class='"+fieldName+"']");
	}
	protected static By Select_Date_Below_Label_Xpath(String fieldName) {
		return By.xpath("(//*[.='"+fieldName+"'])[6]");
	}
	//===========================================================================================

}

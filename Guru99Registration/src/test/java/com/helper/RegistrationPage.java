package com.helper;

import org.openqa.selenium.By;

public class RegistrationPage extends ObjectHelper{
	public static final By firstName = InputBox_Below_Label_Name("firstName");
	public static final By lastName = InputBox_Below_Label_Name("lastName");
	public static final By phone = InputBox_Below_Label_Name("phone");
	public static final By email = InputBox_Below_Label_Name("userName");
	public static final By address = InputBox_Below_Label_Name("address1");
	public static final By city = InputBox_Below_Label_Name("city");
	public static final By state = InputBox_Below_Label_Name("state");
	public static final By postalCode = InputBox_Below_Label_Name("postalCode");
	public static final By country = InputBox_Below_Label_Name("country");
	public static final By userName = InputBox_Below_Label_Name("email");
	public static final By password = InputBox_Below_Label_Name("password");
	public static final By confirmPassword = InputBox_Below_Label_Name("confirmPassword");
	public static final By submit = InputBox_Below_Label_Name("submit");
	public static final By SignInButton = Select_Link_By_LinkText("login.php");


}

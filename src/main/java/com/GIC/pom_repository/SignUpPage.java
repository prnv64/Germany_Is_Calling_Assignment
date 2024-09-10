package com.GIC.pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;
	
	//declaring the Element
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement nameTextField;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passTextField;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpButton;
	
	//Initialize the Element
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Get the Element
	public WebElement getNameTextField() {
		return nameTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPassTextField() {
		return passTextField;
	}
	public WebElement getSignUpButton() {
		return signUpButton;
	}
}

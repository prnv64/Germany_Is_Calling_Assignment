package com.GIC.pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declare the Element
	@FindBy(xpath = "//input[@id='username']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passTextField;
	
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[contains(text(),'New to Germany Is Calling?')]")
	private WebElement signUpLink;
	
	@FindBy(xpath = "//li[contains(text(),'Please enter a correct username and password. Note')]")
	private WebElement invalidUserPass;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement errorMsg;
	
	//Initialize the Element
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Get the Element
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPassTextField() {
		return passTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getSignUpLink() {
		return signUpLink;
	}
	public WebElement getInvalidUserPass() {
		return invalidUserPass;
	}
	public WebElement getErrorMsg() {
		return errorMsg;
	}
}

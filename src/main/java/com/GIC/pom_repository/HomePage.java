package com.GIC.pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//a[@class='d-none d-md-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none']//img")
	private WebElement mainLogo;
	
	@FindBy(xpath = "//span[@class='d-none d-sm-inline mx-1']")
	private WebElement nameDropDown;
	
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logoutOption;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMainLogo() {
		return mainLogo;
	}
	public WebElement getNameDropDown() {
		return nameDropDown;
	}
	public WebElement getLogoutOption() {
		return logoutOption;
	}
}

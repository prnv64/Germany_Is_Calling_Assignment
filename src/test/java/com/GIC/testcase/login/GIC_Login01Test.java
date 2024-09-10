package com.GIC.testcase.login;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GIC.genericlibrary.BaseTest;
import com.GIC.pom_repository.HomePage;
import com.GIC.pom_repository.LoginPage;

public class GIC_Login01Test extends BaseTest{
	@Test
	public void Verify_User_can_Able_To_Login_With_Valid_Credentials() throws EncryptedDocumentException, IOException {
		//Verify it's a Login Page
		String expectedLoginTitle = driver.getTitle();
		String actualLoginTitle = data_Utility.getDataFromExcel("Sheet1", 7, 3);
		if(expectedLoginTitle.contains(actualLoginTitle)) {
			Reporter.log("LoginPage is displayed", true);
		}else {
			Reporter.log("Invalid Url");
		}
		
		//Enter the valid credentials
		LoginPage login = new LoginPage(driver);
		login.getEmailTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 7, 1));
		login.getPassTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 7, 2));
		login.getLoginButton().click();
		
		//Verification for successfull Login
		HomePage home = new HomePage(driver);
		home.getMainLogo().isDisplayed();
		
		String actualUrl = "https://app.germanyiscalling.com/cv/upload/";
		String expectedUrl = driver.getCurrentUrl();
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actualUrl, expectedUrl, "Login Successfull");
		sf.assertAll("Login Unsuccessfull");
		
		//Performing the Logout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(home.getNameDropDown()));
		home.getNameDropDown().click();
		home.getLogoutOption().click();
		
		driver.close();
		
	}
}

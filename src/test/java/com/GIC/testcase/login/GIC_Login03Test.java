package com.GIC.testcase.login;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GIC.genericlibrary.BaseTest;
import com.GIC.pom_repository.LoginPage;

public class GIC_Login03Test extends BaseTest {
	@Test
	public void Verify_That_If_User_Enter_Invalid_Username_We_Should_Get_Proper_Error_Message() throws EncryptedDocumentException, IOException {
		//Verify it's a Login Page
		String expectedLoginTitle = driver.getTitle();
		String actualLoginTitle = data_Utility.getDataFromExcel("Sheet1", 7, 3);
		if(expectedLoginTitle.contains(actualLoginTitle)) {
			Reporter.log("LoginPage is displayed", true);
		}else {
			Reporter.log("Invalid Url");
		}
		
		//Perform Login with Invalid Inputs
		LoginPage login = new LoginPage(driver);
		login.getEmailTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 13, 1));
		login.getPassTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 13, 2));
		login.getLoginButton().click();
		
		//Verification 0f Error Message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(login.getInvalidUserPass()));
		String actualErrorMsg = data_Utility.getDataFromExcel("Sheet1", 13, 3);
		String expectedErrorMsg = login.getInvalidUserPass().getText();
		
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		Reporter.log("Message is displayed and matched", true);
		
		driver.close();
	}
}

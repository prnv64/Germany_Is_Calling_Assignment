package com.GIC.testcase.login;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GIC.genericlibrary.BaseTest;
import com.GIC.pom_repository.LoginPage;

public class GIC_Login04Test extends BaseTest {
	@Test
	public void Verify_That_If_User_Is_Not_Entering_Any_Data_In_Username_And_Password_Textfield_And_Click_On_Login__We_Should_Get_Proper_Error_Message() throws EncryptedDocumentException, IOException {
		//Verify it's a Login Page
		String expectedLoginTitle = driver.getTitle();
		String actualLoginTitle = data_Utility.getDataFromExcel("Sheet1", 7, 3);
		if(expectedLoginTitle.contains(actualLoginTitle)) {
			Reporter.log("LoginPage is displayed", true);
		}else {
			Reporter.log("Invalid Url");
		}
		
		//Perform Login
		LoginPage login = new LoginPage(driver);
		
		login.getEmailTextField().sendKeys("");
		login.getPassTextField().sendKeys("");
		login.getLoginButton().click();
		
		//Verify Error Message
		WebDriverWait wait = new WebDriverWait(listenersDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(login.getErrorMsg()));
		
		String actualErrorMsg = data_Utility.getDataFromExcel("Sheet1", 16, 3);
		String expectedErrorMsg = login.getErrorMsg().getText();
		
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		Reporter.log("Error Message is displayed and Matched", true);
		
		driver.close();
		
	}
}

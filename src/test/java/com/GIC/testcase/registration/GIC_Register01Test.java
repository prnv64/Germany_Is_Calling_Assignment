package com.GIC.testcase.registration;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GIC.genericlibrary.BaseTest;
import com.GIC.pom_repository.LoginPage;
import com.GIC.pom_repository.SignUpPage;

public class GIC_Register01Test extends BaseTest {
	
	@Test
	public void Verify_User_Can_Able_To_Register() throws EncryptedDocumentException, IOException{
		LoginPage loginPage = new LoginPage(driver);
		//goto signup page
		loginPage.getSignUpLink().click();
		
		//Verify the signup page
		String actualSignUpTitle = "Signup | Germany Is Calling";
		if(driver.getTitle().contains(actualSignUpTitle)) {
			Reporter.log("Signup page is displayed", true);
		}else {
			Reporter.log("Page does not match", true);
		}
		
		//Entering all mandatory fields
		SignUpPage signUp = new SignUpPage(driver);
		signUp.getNameTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 1, 1));
		signUp.getEmailTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 1, 2));
		signUp.getPassTextField().sendKeys(data_Utility.getDataFromExcel("Sheet1", 1, 3));
		signUp.getSignUpButton().click();
		
		//Verification the Registration
		SoftAssert sf = new SoftAssert();
		String actualLoginTitle = "Login | Germany Is Calling";
		String expectedLoginTitle = driver.getTitle();
		sf.assertEquals(actualLoginTitle,expectedLoginTitle ,"Registration Successfull");
		
		driver.close();
	}
}

package com.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void goLoginPage() throws InterruptedException {
		String iconloginID = PropertiesFileUtils.getProperty("icon_login");
		WebElement iconLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconloginID)));
		iconLogin.click();
		Thread.sleep(2000);
	}

	public void enteremail(String email) throws InterruptedException {
		String loginemailID = PropertiesFileUtils.getProperty("login_email");
		WebElement inputemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginemailID)));
		inputemail.sendKeys(email);
		Thread.sleep(2000);
	}

	public void enterpassword(String password) throws InterruptedException {
		String loginpasswordID = PropertiesFileUtils.getProperty("login_password");
		WebElement inputpassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginpasswordID)));
		inputpassword.sendKeys(password);
		Thread.sleep(2000);
	}

	public void clickLogin() throws InterruptedException {
		String btnloginID = PropertiesFileUtils.getProperty("login_button");
		WebElement btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnloginID)));
		btnLogin.click();
		Thread.sleep(2000);
	}

	public void clickLogout() throws InterruptedException {
		String iconlogoutID = PropertiesFileUtils.getProperty("icon_logout");
		WebElement iconLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconlogoutID)));
		Assert.assertEquals(true, iconLogout.isDisplayed());
		iconLogout.click();
		Thread.sleep(2000);
	}
}

package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.utils.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;

	@BeforeClass
	public void initDriverInstance() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",".\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL=PropertiesFileUtils.getProperty("base_url");
		driver.get(URL);
	}

	@AfterClass
	public void closeDriverInstance() {
		driver.close();
	}
}
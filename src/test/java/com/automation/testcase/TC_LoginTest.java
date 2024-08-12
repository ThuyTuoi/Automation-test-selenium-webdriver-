package com.automation.testcase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenShot;


public class TC_LoginTest extends DriverInstance {

	@Test(dataProvider = "Excel")
	public void TC01_LoginFirstAccount(String email, String password) throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		PageFactory.initElements(driver, loginpage);
		loginpage.goLoginPage();
		loginpage.enteremail(email);
		loginpage.enterpassword(password);
		loginpage.clickLogin();
		loginpage.clickLogout();
	}

	@DataProvider(name = "Excel")
	public Object[][] testDataGenerator() throws IOException {
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Login");
		int numberofrowdata = loginsheet.getPhysicalNumberOfRows();
		Object[][] data = new Object[numberofrowdata][2];
		for (int i = 0; i < numberofrowdata; i++) {
			XSSFRow row = loginsheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			data[i][0] = username.getStringCellValue();
			data[i][1] = password.getStringCellValue();
		}
		return data;
	}

	@AfterMethod
	public void Takescreenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				String email = (String) result.getParameters()[0];//1. Lấy tham số (parameters) đầu vào của TC vừa chạy- email:0, password:1
				int index = email.indexOf('@');
				String accountName = email.substring(0, index);
				CaptureScreenShot.takescreenshot(driver, accountName);
				System.out.println("Đã chụp màn hình: " + accountName);
			} catch (Exception e) {
				System.out.println("Lỗi xảy ra screenshot " + e.getMessage());
			}
		}
	}
}

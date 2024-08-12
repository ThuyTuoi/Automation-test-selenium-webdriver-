package com.automation.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {
	public static void takescreenshot(WebDriver driver, String TC01) {
		try {
			File screenshot=new File("./ScreenShots");
			if(!screenshot.exists()) {
				screenshot.mkdirs();
			}
			String imageName=TC01 + ".png";
			TakesScreenshot Scrshot=((TakesScreenshot) driver);
			File source=Scrshot.getScreenshotAs(OutputType.FILE);
			File destiny=new File("./ScreenShots/"+imageName);
			FileHandler.copy(source,destiny);
		}catch(Exception e) {
			System.out.println("Đã xảy ra lỗi khi chụp màn hình");
			e.printStackTrace();
		}
		
	}
}

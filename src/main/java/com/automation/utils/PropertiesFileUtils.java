package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
	private static String Config_path = "./configuration/configs.properties";

	public static String getProperty(String key) {
		Properties properties = new Properties();
		String value = null;
		FileInputStream fileinputStream = null;
		try {
			fileinputStream = new FileInputStream(Config_path);
			properties.load(fileinputStream);
			value = properties.getProperty(key);
			return value;
		} catch (Exception ex) {
			System.out.println("Xảy ra lỗi khi đọc giá trị của " + key);
			ex.printStackTrace();
		} finally {
			if (fileinputStream != null) {
				try {
					fileinputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
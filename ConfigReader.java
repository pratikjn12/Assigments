package org.Corpository.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties prop;

	public ConfigReader() {

		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir")+"/Config/ProjectConfig.properties"));

			prop = new Properties();

			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

	public String getusername() {

		String uname = prop.getProperty("Username");
		return uname;

	}

	public String getPassword() {
		String pass = prop.getProperty("Password");
		return pass;
	}

	public String getApplicationUrl() {
		String url = prop.getProperty("Appurl");
		return url;
	}

	public String browser() {
		String Browsername = prop.getProperty("Browsername");
		return Browsername;
	}

	
}

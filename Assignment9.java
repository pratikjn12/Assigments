package org.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//This validates the Title of the Page

public class Assignment9 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		String str1 = driver.getTitle();

		System.out.println(str1);

		if (str1.contains("login"))

		{
			System.out.println("String Matched");

		}

		else {

			System.out.println("String Not Matched");

		}

	}

}

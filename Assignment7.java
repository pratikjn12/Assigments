package org.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Validated It is free text

public class Assignment7 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		String str = driver.findElement(By.xpath("//div[@class = '_52lr fsm fwn fcg']")).getText();

		System.out.println(str);

		if (str.equalsIgnoreCase("It's free and always will be."))

		{
			System.out.println("String Matched");
		}

		else {
			System.out.println("String not matched");
		}

		driver.quit();
	}

}

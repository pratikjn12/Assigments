package org.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Validates the Birthdate based on the getfisrtselectedoption

public class Assignment4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("firstname")).sendKeys("qa123");
		driver.findElement(By.name("lastname")).sendKeys("qatest");
		driver.findElement(By.name("reg_email__")).sendKeys("qa@qa.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("qa123");
		
		Select bday = new Select(driver.findElement(By.name("birthday_day")));
		bday.selectByValue("25");
		
		System.out.println(bday.getFirstSelectedOption().getText());
		
		Select bmonth = new Select(driver.findElement(By.name("birthday_month")));
		bmonth.selectByIndex(10);
		
		System.out.println(bmonth.getFirstSelectedOption().getText());
		
		Select byear = new Select(driver.findElement(By.name("birthday_year")));
		byear.selectByValue("1985");
		
		System.out.println(byear.getFirstSelectedOption().getText());
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();

	}

}

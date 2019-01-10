package org.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement elem1 = driver.findElement(By.xpath("//input[@id = 'datepicker']"));
		elem1.click();

		List<WebElement> elem2 = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//td//a"));

		for (WebElement elem3 : elem2)

		{
			String dt = elem3.getText();

			if (dt.equalsIgnoreCase("6")) {

				elem3.click();
				break;
			}
		}
		driver.close();
	}

}

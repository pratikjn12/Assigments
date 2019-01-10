package org.assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2017/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement frame1 = driver.findElement(By.id("google"));

		driver.switchTo().frame(frame1);

		driver.findElement(By.cssSelector(".fusion-social-network-icon")).click();

		String parent = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();

		while (itr.hasNext())

		{
			String child_window = itr.next();

			if (!(parent.equals(child_window)))

			{
				driver.switchTo().window(child_window);
				System.out.println("Current URL" + driver.getCurrentUrl());
				System.out.println("Title of the page" + driver.getTitle());
				driver.close();
				
			}

		}

		driver.switchTo().window(parent);
		System.out.println("Current URL" + driver.getCurrentUrl());
		System.out.println("Title of the page" + driver.getTitle());
		driver.close();
	}

}

package org.assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2017/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String parent = driver.getWindowHandle();
		System.out.println("Print parent Window" + parent);

		driver.findElement(By.xpath("//a[@href = 'http://www.google.com']")).click();
		driver.findElement(By.xpath("//a[@href = 'http://www.facebook.com']")).click();
		driver.findElement(By.xpath("//a[@href = 'http://www.yahoo.com']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Session')]")).click();

		Set<String> child = driver.getWindowHandles();

		Iterator<String> itr = child.iterator();

		while (itr.hasNext())

		{
			String child_window = itr.next();

			if (!(parent.equalsIgnoreCase(child_window))) {
				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		System.out.println(driver.switchTo().window(parent).getTitle());
		driver.close();
	}

}

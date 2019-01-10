package org.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnalyticsDemo {
	public WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\AutomationFramework\\Analytics\\Browser Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://10.121.18.58:42080");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("stladmin");
		driver.findElement(By.name("password")).sendKeys("stladmin");

		driver.findElement(By.cssSelector("button.btn-login")).click();

		System.out.println("Login Successfull");

		driver.findElement(By.xpath("//h3/a/i")).click();

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("QADemo");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("QADemo");
		driver.findElement(By.cssSelector("input[id='verifyPassword']")).sendKeys("QADemo");
		driver.findElement(By.cssSelector("input[id='emailid']")).sendKeys("QADemo@QA.com");
		driver.findElement(By.cssSelector("input[id='phoneno']")).sendKeys("8541245841");
		Thread.sleep(5000L);

	}

	public void closebrowser() {
		driver.quit();

	}

}

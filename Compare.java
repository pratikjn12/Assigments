package com.assignmentfive;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Compare {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.contextures.com/xlSampleData01.html");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement table = driver.findElement(By.xpath("//table"));
		List<WebElement> trow = table.findElements(By.tagName("tr"));

		for (WebElement rowdata : trow) {

			StringBuilder alldata = new StringBuilder();
			List<WebElement> tcol = rowdata.findElements(By.tagName("p"));

			for (WebElement tcoldata : tcol) {
				String data = tcoldata.getText();
				alldata.append(data).append("||");
			}

			System.out.println(alldata);
		}

		driver.quit();
	}

}

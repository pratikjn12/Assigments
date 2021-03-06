package com.Corpository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Compare {
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.contextures.com/xlSampleData01.html");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void webtabledata() {
		JsonObject row = null;
		ArrayList <Object> bodyList = new ArrayList<Object>();
		ArrayList <Object> headerList = new ArrayList <Object>();

		WebElement table = driver.findElement(By.xpath("//table"));
		List<WebElement> trow = table.findElements(By.tagName("tr"));
		int i = 0;
		for (WebElement rowdata : trow) {
			List<WebElement> tcol = rowdata.findElements(By.tagName("p"));

			if (i == 0) {
				for (WebElement tcoldata : tcol) {
					String data = tcoldata.getText();
					headerList.add(data);
				}
			} else {
				row = new JsonObject();
				int headerCol = 0;
				for (WebElement tcoldata : tcol) {
					String data = tcoldata.getText();
					row.addProperty((String) headerList.get(headerCol), data);
					headerCol++;
				}
				bodyList.add(row);
			}
			i++;
		}

		System.out.println(bodyList);	
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}

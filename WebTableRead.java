package com.Corpository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableRead {
	public WebDriver driver;

	Map<Integer, Map<String, String>> tabledata = new HashMap<Integer, Map<String, String>>();
	List<String> header = new ArrayList<String>();
	Map<String, String> tmp = new HashMap<String, String>();
	int i;
	

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

		WebElement table = driver.findElement(By.xpath("//table"));
		List<WebElement> trow = table.findElements(By.tagName("tr"));
		for (WebElement rowdata : trow) {

			List<WebElement> tcol = rowdata.findElements(By.tagName("p"));
			int j=0;
			tmp.clear();
			for (WebElement tcoldata : tcol) {
				
				String data = tcoldata.getText();

				if (i == 0) {
				header.add(data);
				}else {
					tmp.put(header.get(j), data);
				}
				
				j++;
			}
			System.out.println("=================="+tmp);
			if (i != 0)
				tabledata.put(i, tmp);
			//System.out.println("============"+tabledata.get(i));
			i++;
			
			
		}

		//System.out.println("");
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}

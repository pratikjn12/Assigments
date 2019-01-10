package org.assignment;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtablewithiterator {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement table = driver.findElement(By.xpath("//table[@class = 'dataTable']"));

		List<WebElement> trow = table.findElements(By.tagName("tr"));
		Iterator<WebElement> itr = trow.iterator();
		while (itr.hasNext()) {

			List<WebElement> tcol = itr.next().findElements(By.tagName("td"));
			StringBuilder strbuild = new StringBuilder();
			for (WebElement webl : tcol)

			{
				strbuild.append(webl.getText()).append("|");
			}

			System.out.println(strbuild);
		}

	}

}

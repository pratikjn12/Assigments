package org.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");

		// Validates All the URL Available or Not

		WebElement socialmedia = driver.findElement(By.xpath("//div[@id = 'social-icons']"));
		List<WebElement> socialmedialist = socialmedia.findElements(By.tagName("a"));

		for (WebElement elem : socialmedialist)

		{
			String urllist = elem.getAttribute("href");
			System.out.println("Get the Idea of which URL matched or not :" + urllist);

			if (urllist.equalsIgnoreCase("http://www.linkedin.com/groups?home=&gid=891077"))

			{
				System.out.println("Linkedin URL Matched");
			}

			else if (urllist.equalsIgnoreCase("http://www.facebook.com/OrangeHRM")) {
				System.out.println("Facebook URL Matched");
			}

			else if (urllist.equalsIgnoreCase("http://twitter.com/orangehrm")) {
				System.out.println("Twitter URL Matched");
			}

			else if (urllist.equalsIgnoreCase("http://www.youtube.com/orangehrm")) {
				System.out.println("youtube URL Matched");
			} else {
				System.out.println("All URL Not Matched");
			}
		}
		driver.quit();
	}
}

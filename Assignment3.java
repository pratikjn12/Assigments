package org.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	public static void main(String[] args)

	{

		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();

		String title = driver.getTitle();

		System.out.println("Title of the page After Login :" + title);

		if (title.equalsIgnoreCase("OrangeHRM"))

		{
			System.out.println(" 1. Title has been matched");
		}

		else {
			System.out.println(" 1. Title of the page not matched");
		}

		WebElement url = driver.findElement(By.cssSelector("#menu_directory_viewDirectory"));
		url.click();
		String directory = driver.getCurrentUrl();

		System.out.println(" Print URL" + directory);

		if (directory.contains("viewDirectory"))

		{
			System.out.println(" 2. URL contains the ViewDirectory ");
		}

		else {
			System.out.println(" 2. URL contains the ViewDirectory ");
		}

		List<WebElement> searchbox = driver.findElements(By.xpath("//input[@type = 'text']"));
		int count = searchbox.size();
		System.out.println(" Count of the Searchbox " + count);

		List<WebElement> dropdownbox = driver.findElements(By.tagName("select"));
		int count1 = dropdownbox.size();
		System.out.println(" Count of the Drop down " + count1);

		if (count >= 1 && count1 >= 2)

		{

			System.out.println(" 3. Count has been matched");
		}

		else

		{
			System.out.println(" 3. Count not matched ");
		}

		WebElement titles = driver.findElement(By.cssSelector("#searchDirectory_job_title"));
		Select oselect = new Select(titles);
		List<WebElement> titleoption = oselect.getOptions();

		for (WebElement elem : titleoption) {

			String optiondata = elem.getText().trim();

			if (optiondata.equalsIgnoreCase("Sales Manager"))

			{
				System.out.println(" 4. Find the Record Matched ");
				break;
			}

		}

		WebElement locations = driver.findElement(By.cssSelector("#searchDirectory_location"));
		Select lselect = new Select(locations);
		List<WebElement> locationoption = lselect.getOptions();
		boolean loc = false;
		for (WebElement elem1 : locationoption) {
			String loptiondata = elem1.getText().trim();
			if (loptiondata.equalsIgnoreCase("Canadian Development Center"))

			{
				System.out.println("5. Location Record Matched");
				loc = true;
				break;
			}

		}
		if (loc == false)

		{
			System.out.println("Location Record Deos Not Match");
		}

		driver.findElement(By.cssSelector("#searchDirectory_emp_name_empName")).sendKeys("Linda Anderson");
		driver.findElement(By.cssSelector("#searchBtn")).click();
		WebElement searchrecord = driver.findElement(By.xpath("//b[contains(text(),'Linda Anderson')]"));
		String record = searchrecord.getText();
		if (record.equalsIgnoreCase("Linda Anderson"))

		{
			System.out.println("6. Record Matched");
		}

		else

		{
			System.out.println("6. Record Not match");
		}
		driver.quit();
	}
}

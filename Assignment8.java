package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Validates male radio button is selected or not.

public class Assignment8 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratik.jain\\Desktop\\Assignment\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		WebElement Male = driver.findElement(By.id("u_0_a"));

		if (Male.isSelected())

		{
			System.out.println("Male is not selected");

		}

		else {
			Male.click();

			System.out.println("Male radio is Checked");

			if (Male.isSelected())

			{
				System.out.println("Male Is selected and It is True and Varified");
			}

			else {
				System.out.println("Not verified");
			}

		}
		driver.quit();
	}

}

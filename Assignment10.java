package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratik.jain\\Desktop\\Assignment\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		// Locate Element

		WebElement element = driver.findElement(By.name("websubmit"));

		// Get the font Size
		String fontsize = element.getCssValue("font-size");

		System.out.println("Size of the button :" + fontsize);

		// validation font size

		if (fontsize.equals("19px"))

		{

			System.out.println("Size of the button matched");

		}

		else {
			System.out.println("Size of the button matched");
		}

		String signup = element.getText();

		// validating Assignment10 button to click

		if (signup.equalsIgnoreCase("sign up"))

		{

			element.click();
			System.out.println("Sign up button Click Done");

		}

		else {
			System.out.println("Sign up button not found");
		}

		driver.quit();
	}

}

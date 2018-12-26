package assignment1;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This validates and get the Input from user for Browser.

public class Assignment5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String browserName = scan.nextLine();

		if (browserName.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\pratik.jain\\Desktop\\Assignment\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			String title = driver.getTitle();
			System.out.printf(title);
			driver.close();

			if (title.contains("login") || title.contains("Login"))

			{
				System.out.println("String matched");
			}

		}

		else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pratik.jain\\Desktop\\Assignment\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			String title1 = driver.getTitle();

			if (title1.contains("Google")) {
				System.out.println("String matched");

			}

			driver.quit();
		}

	}

}

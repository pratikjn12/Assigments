package assignment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratik.jain\\Desktop\\Assignment\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();
		System.out.println("Title of the page After Login :" + driver.getTitle());

		WebElement element = driver.findElement(By.cssSelector("#welcome"));
		String welcome = element.getText();
		System.out.println("Welcome Admin Tag :" + welcome);

		String currenturl = driver.getCurrentUrl();
		if (currenturl.contains("dashboard"))

		{
			System.out.println("Yes URL Has Dashbaord");
		}

		else {
			System.out.println("URL Does not have dashbaord");
		}

		// User Add functionality
		WebElement admin = driver.findElement(By.tagName("b"));

		Actions action = new Actions(driver);
		action.moveToElement(admin).perform();

		WebElement usermanagement = driver.findElement(By.cssSelector("#menu_admin_UserManagement"));
		WebElement user = driver.findElement(By.cssSelector("#menu_admin_viewSystemUsers"));

		System.out.println("Menu Name" + usermanagement);
		action.moveToElement(usermanagement).perform();

		user.click();

		driver.findElement(By.cssSelector("#btnAdd")).click();

		WebElement userrole = driver.findElement(By.cssSelector("#systemUser_userType"));
		Select userole = new Select(userrole);
		userole.selectByValue("2");
		driver.findElement(By.cssSelector("#systemUser_employeeName_empName")).sendKeys("Jasmine Morgan");
		driver.findElement(By.cssSelector("#systemUser_userName")).sendKeys("Selenium504");

		WebElement status = driver.findElement(By.cssSelector("#systemUser_status"));
		Select userstatus = new Select(status);
		userstatus.selectByValue("1");

		driver.findElement(By.cssSelector("#systemUser_password")).sendKeys("Selenium504");
		driver.findElement(By.cssSelector("#systemUser_confirmPassword")).sendKeys("Selenium504");
		driver.findElement(By.cssSelector("#btnSave")).click();

		Thread.sleep(3000L);

		WebElement search = driver.findElement(By.cssSelector("#searchSystemUser_userName"));
		search.sendKeys("Selenium503");
		driver.findElement(By.cssSelector("#searchBtn")).click();

		// Locate Table Then Row and Then Delete respected Record.

		WebElement tbl = driver.findElement(By.cssSelector("#resultTable"));

		driver.findElement(By.cssSelector("#ohrmList_chkSelectAll")).click();
		driver.findElement(By.cssSelector("#btnDelete")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println("Record Deleted Successfuly:");

		driver.close();
	}
}

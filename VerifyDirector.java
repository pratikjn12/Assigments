package org.Corpository.testcases;

import org.Corpository.factory.Browserconfig;
import org.Corpository.factory.DataProviderFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyDirector {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void startbrowser() {
		driver = Browserconfig.startBrowser(DataProviderFactory.getConfig().browser(),
				DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test(priority = 0)
	public void login() {
		driver.findElement(By.xpath("//input[@name='username']"))
				.sendKeys(DataProviderFactory.getConfig().getusername());
		driver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys(DataProviderFactory.getConfig().getPassword());
		driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']//div[@class='mat-checkbox-inner-container']"))
			.click();
		driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
	}

	@Test(priority = 1, dependsOnMethods = "login")
	public void addandverifydirector() throws Exception {

		// DataProviderFactory.getExcel().getrowcount(0)
		Thread.sleep(3000L);
		WebElement adddirector = driver.findElement(By.xpath("//span[contains(text(),'VERIFY A DIRECTOR/PARTNER')]"));
		adddirector.click();
		for (int i = 11; i <=20; i++) {

			try {
				driver.findElement(By.xpath("//input[@name='name']"))
						.sendKeys(DataProviderFactory.getExcel().getData(0, i, 0).trim());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				driver.findElement(By.xpath("//input[@name='pan']"))
						.sendKeys(DataProviderFactory.getExcel().getData(0, i, 1).trim());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				driver.findElement(By.xpath("//input[@name = 'remarks']"))
						.sendKeys(DataProviderFactory.getExcel().getData(0, i, 2).trim());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			driver.findElement(By.xpath("//span[contains(text(),'SEARCH')]")).click();
			Thread.sleep(1500L);

			try {
				Thread.sleep(1500L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			System.out.println("Print Value of I =" + i);

		}

	}

	/*
	 * 
	 * @Test(priority = 2, dependsOnMethods = { "login", "addandverifydirector" })
	 * public void pending() throws Exception {
	 * 
	 * driver.findElement(By.xpath("//img[@class='logo cursor-event']")).click();
	 * 
	 * WebElement pending =
	 * driver.findElement(By.xpath("//a[contains(text(),'Pending')]"));
	 * wait.until(ExpectedConditions.visibilityOf(pending)).click();
	 * 
	 * for (int k = 19; k <= 20; k++)
	 * 
	 * { driver.findElement(By.xpath("//input[@type='search']"))
	 * .sendKeys(DataProviderFactory.getExcel().getData(0, k, 1));
	 * 
	 * String narecords =
	 * driver.findElement(By.xpath("//div[contains(@class,'no-data-message')]")).
	 * getText(); if (narecords.equalsIgnoreCase("Sorry, no records found")) {
	 * System.out.println("No Records Error"); } else {
	 * 
	 * WebElement pendingdir =
	 * driver.findElement(By.xpath("//span[@class = 'director-name']")); String pend
	 * = pendingdir.getText(); System.out.println("Director Name" + pend);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * @Test(priority = 3, dependsOnMethods = { "login", "addandverifydirector" })
	 * public void unverified() throws Exception {
	 * 
	 * WebElement unverified =
	 * driver.findElement(By.xpath("//a[contains(text(),'Unverified')]"));
	 * wait.until(ExpectedConditions.visibilityOf(unverified)).click();
	 * 
	 * for (int k = 19; k <= 20; k++)
	 * 
	 * { driver.findElement(By.xpath("//input[@type='search']"))
	 * .sendKeys(DataProviderFactory.getExcel().getData(0, k, 1));
	 * 
	 * String norecords =
	 * driver.findElement(By.xpath("//div[contains(@class,'no-data-message')]")).
	 * getText(); if (norecords.equalsIgnoreCase("Sorry, no records found")) {
	 * System.out.println("No Records Error"); } else {
	 * 
	 * WebElement unverifiedelem =
	 * driver.findElement(By.xpath("//span[@class = 'director-name']")); String
	 * unveridirname = unverifiedelem.getText(); System.out.println("Director Name"
	 * + unveridirname);
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * @Test(priority = 4, dependsOnMethods = { "login", "addandverifydirector",
	 * "unverified" }) public void verified() throws Exception {
	 * 
	 * for (int j = 19; j <= 20; j++)
	 * 
	 * driver.findElement(By.xpath("//input[@type='search']"))
	 * .sendKeys(DataProviderFactory.getExcel().getData(0, j, 0)); {
	 * 
	 * String norecord =
	 * driver.findElement(By.xpath("//div[@class='no-data-message']")).getText();
	 * 
	 * if (norecord.equalsIgnoreCase("Sorry, no records found")) {
	 * System.out.println("No Records Found"); } else {
	 * 
	 * WebElement verifiedelem =
	 * driver.findElement(By.xpath("//span[@class = 'director-name']")); String
	 * dirname = verifiedelem.getText(); System.out.println("Existed Director Name"
	 * + dirname); } } }
	 */

	@AfterTest
	public void browserclose() {
		driver.close();
	}

}

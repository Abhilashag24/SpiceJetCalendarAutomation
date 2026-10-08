package com.spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetAutomation {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String toCity = "Agr";
		By fromTextBoxLocator = By.xpath("//div[text()='From']/../div[2]/input"); // //div[text()='From']/following-sibling::div/input
		By toTextBoxLocator = By.xpath("//div[text()='To']/../div[2]/input");
		By regionCityDialogLocator = By.xpath("//div[contains(text(),'Select a region and city below')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromTextBoxLocator)).sendKeys("Mum");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toTextBoxLocator)).sendKeys(toCity);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(regionCityDialogLocator));

			By toCityLocator = By.xpath("//div[contains(text(),'" + toCity + "')]");
			wait.until(ExpectedConditions.elementToBeClickable(toCityLocator)).click();

		} catch (Exception e) {

			System.out.println("No dialog appeared ...continue with the flow");
		}
		By calendarPickerLocator = By.xpath("//div[@data-testid=\"undefined-calendar-picker\"]");
		WebElement calenadarPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPickerLocator));
		By nextButtonLocator = By.xpath(".//*[local-name()='svg' and @data-testid=\"svg-img\"]");
		calenadarPicker.findElement(nextButtonLocator).click();

		By dateLocator = By.xpath("//div[contains(text(),'9')]");
		wait.until(ExpectedConditions.elementToBeClickable(dateLocator)).click();
	}

}

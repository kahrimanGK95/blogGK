package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;
/**
 * Die Testklasse testet das erfolgreiche Login zu der Blog-Seite.
 * @author gokha
 *
 */
public class LoginToBlogTestNG extends SetupTestNG {

	@Test
	public void loginToBlogPageWithSuccess() throws IllegalArgumentException, IOException, InterruptedException {
		browser.manage().window().maximize();
		browser.get(getUrl());
		Thread.sleep(500);

		// Eingabefelder identifizieren und ausfüllen
		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("Gokhan1995");

		// Einloggen
		WebElement clickButton = browser.findElement(By.cssSelector("input[type=submit]"));
		clickButton.click();

		// Warten, bis die Seite sich geladen hat und überpüfen des Titels der Blog-Seite.
		WebDriverWait wait = new WebDriverWait(browser, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h1")));
		String blogTitle = browser.findElement(By.xpath("/html/body/div/h1")).getText();
		assertEquals("Herzlich Willkomen zu unserem Blog-GK", blogTitle);

	}
}

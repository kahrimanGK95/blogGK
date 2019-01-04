package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

/**
 * Die Testklasse testet das mit Absicht geplante Fehlschlag des Logins, um zu
 * überprüfen, ob die Datenbank-Abfrage richtig umgesetzt wird.
 * 
 * @author gokha
 *
 */
public class LoginNotToBlogTestNG extends SetupTestNG {

	@Test
	public void loginToBlogWithFailure() throws IllegalArgumentException, IOException, InterruptedException {
		browser.manage().window().maximize();
		browser.get(getUrl());
		Thread.sleep(500);

		// Eingabefelder ausfüllen mit falschem Passwort
		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("WrongPassword");

		// Einloggen
		WebElement clickButton = browser.findElement(By.cssSelector("input[type=submit]"));
		clickButton.click();

		// Das Login sollte fehlschlagen, das heißt man wird nicht weitergeleitet und bleibt auf der Startseite.
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommen", title);
	}
}

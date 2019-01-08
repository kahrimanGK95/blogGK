package meinBlogGK.seleniumTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

/**
 * Die Testklasse testet das Login/Logout der WebAnwendung.
 * 
 * @author gokha
 *
 */
public class LoginLogoutTestNG extends SetupTestNG {

	@Test
	public void checkToLoginLogout() throws IllegalArgumentException, IOException, InterruptedException {
		browser.manage().window().maximize();
		browser.get(getUrl());
		Thread.sleep(500);

		// Eingabefelder für Benutzername und Passwort identifizieren und ausfüllen
		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("Gokhan1995");

		// LoginButton anklicken
		WebElement clickButton = browser.findElement(By.cssSelector("input[type=submit]"));
		clickButton.click();

		// Es wird verglichen, ob die angemeldete Person dem User gleich ist.
		WebElement person = browser.findElement(By.xpath("//span[text()='Angemeldet: Kahriman']"));
		String name = person.getText();
		assertEquals("Angemeldet: Kahriman", name);

		// Als erstes wird darauf gewartet, dass der Button identifiziert wird auf der
		// Seite und danach wird Ausloggen angeklickt.
		WebDriverWait wait = new WebDriverWait(browser, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='infoPerson:ausloggen']")));
		WebElement clickAusloggenButton = browser.findElement(By.cssSelector("input[id='infoPerson:ausloggen']"));
		clickAusloggenButton.click();

		// Überprüfung findet statt, ob auf der Startseite wieder gelandet wird.
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommen", title);
	}
}

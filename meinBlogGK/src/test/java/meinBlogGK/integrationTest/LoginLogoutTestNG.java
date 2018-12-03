package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

public class LoginLogoutTestNG extends SetupTestNG {

	@Test
	public void checkToLoginLogout() throws IllegalArgumentException, IOException, InterruptedException {
		browser.manage().window().maximize();
		browser.get(getUrl());
		Thread.sleep(500);

		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("Gokhan1995");

		WebElement clickButton = browser.findElement(By.cssSelector("input[type=submit]"));
		clickButton.click();
		
		WebDriverWait wait = new WebDriverWait(browser, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='infoPerson:ausloggen']")));
		WebElement clickAusloggenButton = browser.findElement(By.cssSelector("input[id='infoPerson:ausloggen']"));
		clickAusloggenButton.click();
		
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommen", title);
	}
}

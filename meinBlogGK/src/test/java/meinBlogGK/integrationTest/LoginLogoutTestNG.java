package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

public class LoginLogoutTestNG extends SetupTestNG{
	
	@Test
	public void checkToLoginLogout() throws IllegalArgumentException, IOException, InterruptedException {
		Dimension d = new Dimension(1044, 784);
		browser.manage().window().setSize(d);
		browser.get(getProperties().getProperty("meinBlogGK"));
		Thread.sleep(500);
		
		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("Gokhan1995");
		browser.findElement(By.id("loginForm:einloggen")).click();
		Thread.sleep(1000);
		
		String angemeldeterName = browser.findElement(By.xpath("//*[@id=\"ausloggenForm\"]/p")).getText();
		assertEquals("Angemeldet: Kahriman", angemeldeterName);
		
		browser.findElement(By.id("ausloggenForm:ausloggen")).click();
		Thread.sleep(500);
		
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommen", title);
	}
}

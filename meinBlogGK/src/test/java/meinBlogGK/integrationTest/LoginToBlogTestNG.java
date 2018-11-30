package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

public class LoginToBlogTestNG extends SetupTestNG {
	
	@Test
	public void loginToBlogPageWithSuccess() throws IllegalArgumentException, IOException, InterruptedException {
		Dimension d = new Dimension(1044, 784);
		browser.manage().window().setSize(d);
		browser.get(getUrl());
		Thread.sleep(500);
		
		WebElement inputBenutzername = browser.findElement(By.id("loginForm:username"));
		WebElement inputPassword = browser.findElement(By.id("loginForm:password"));
		
		inputBenutzername.sendKeys("Kahriman");
		inputPassword.sendKeys("Gokhan1995");
		browser.findElement(By.id("loginForm:einloggen")).click();
		Thread.sleep(1000);
		
		String blogTitle = browser.findElement(By.xpath("/html/body/div/h1")).getText();
		assertEquals("Herzlich Willkomen zu unserem Blog-GK", blogTitle);
		
		
	}
}

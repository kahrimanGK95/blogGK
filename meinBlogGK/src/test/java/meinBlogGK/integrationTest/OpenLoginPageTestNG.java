package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

/**
 * Die Testklasse testet, ob die Web-Anwendung erfolgreich geladen worden ist
 * und über einen Web-Browser aufzurufen ist.
 * 
 * @author gokha
 *
 */
public class OpenLoginPageTestNG extends SetupTestNG {

	@Test
	public void openBlogPage() throws IllegalArgumentException, IOException, InterruptedException {
		browser.manage().window().maximize();
		browser.get(getUrl());
		Thread.sleep(1000);
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommen", title);

	}
}

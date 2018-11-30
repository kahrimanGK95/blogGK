package meinBlogGK.integrationTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

public class OpenLoginPageTestNG extends SetupTestNG {
	
	@Test
	public void openBlogPage() throws IllegalArgumentException, IOException, InterruptedException {
		Dimension d = new Dimension(1044, 784);
		browser.manage().window().setSize(d);
		browser.get(getUrl());
		Thread.sleep(1000);
		String title = browser.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
		assertEquals("Herzlich Willkommaaen", title);
		
	}
}

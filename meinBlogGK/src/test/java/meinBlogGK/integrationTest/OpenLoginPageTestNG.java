package meinBlogGK.integrationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import meinBlogGK.test.model.SetupTestNG;

public class BlogTestNG extends SetupTestNG {
	
	@Test
	public void openGoogleTest() throws IllegalArgumentException, IOException {
		browser.manage().window().maximize();
		browser.get(getProperties().getProperty("meinBlogGK"));
	}
}

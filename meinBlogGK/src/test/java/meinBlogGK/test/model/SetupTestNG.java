package meinBlogGK.test.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class SetupTestNG {

	public static final Logger LOG = Logger.getLogger(SetupTestNG.class.getName());

	protected WebDriver browser;

	private final static String propertiesPath = "test_config.properties";

	private static WebDriver getWebBrowser() throws MalformedURLException {

		Map<String, Object> preferences = new Hashtable<>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		if (remotePropertiesGesetzt()) {
			return new RemoteWebDriver(new URL(System.getProperty("webdriver.remote.url")), capabilities);
		} else {
			return new ChromeDriver(capabilities);
		}

	}

	@BeforeClass
    public void beforeClassInitialization() throws IllegalArgumentException, IOException {
    	System.setProperty("webdriver.chrome.driver", getProperties().getProperty("pathToChromeDriver"));
        browser = getWebBrowser();
    }

	@AfterClass
	public void afterClass() {
		browser.close();
	}

	private static boolean remotePropertiesGesetzt() {
		return System.getProperty("webdriver.remote.url") != null;
	}

	public static Properties getProperties() throws IOException, IllegalArgumentException {

		Properties properties = new Properties();
		InputStream inputStream = SetupTestNG.class.getClassLoader().getResourceAsStream(propertiesPath);
		properties.load(inputStream);

		return properties;

	}

}

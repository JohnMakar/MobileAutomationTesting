package org.rahulshetty;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.rahulshetty.PageObject.android.FormPage;
import org.rahulshetty.Utils.AppiumUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass extends AppiumUtils{
	public AndroidDriver driver;
	protected FormPage formPage;
	
	@BeforeMethod(alwaysRun = true)
	public void ConfigureAppium() throws URISyntaxException, IOException
	{
		Properties prop = new Properties();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp("D:\\Automation.Michael\\AppiumProject\\src\\test\\java\\reSrcs\\General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage=new FormPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}


}

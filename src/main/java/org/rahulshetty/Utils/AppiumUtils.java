package org.rahulshetty.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AppiumUtils {
	
	public Double GetFormattedAmount(String Amount) {
		Double Price = Double.parseDouble(Amount.substring(1));
		return Price;
	}
	
	public List<HashMap<String,String>>getJsonData(String jsonFilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,
				new TypeReference <List<HashMap<String ,String >>>(){
		});
		return data;
	}
	
	public void waitForElementAppear(WebElement Element,AndroidDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(Element, "text", "Cart"));
	}
	
	public String getScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException {
		File Src = driver.getScreenshotAs(OutputType.FILE);
		String DstFile =System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(Src,new File(DstFile));
		return DstFile;
	}
}

package org.rahulshetty.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left",100 ,"top" ,100,"width",200,"height",200,
					"direction","down",
					"percent",3.0
					));
		}while(canScrollMore);
	}
	public Double GetFormattedAmount(String Amount) {
		Double Price = Double.parseDouble(Amount.substring(1));
		return Price;
	}

	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ text +"\"));"));
	}
	
	public void longPressAction(WebElement Element) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture"
				, ImmutableMap.of("elementId",((RemoteWebElement)Element).getId(),
				"duration",2000));
	}
	

	


}

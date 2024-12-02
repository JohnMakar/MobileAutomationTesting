package org.rahulshetty;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormPageTest extends BaseClass{
	@Test(dataProvider = "getData" ,groups ={"smoke"})
	public void FillForm_HappyScenario(HashMap<String,String> input) throws InterruptedException {
		formPage.setCountrySelection(input.get("country"));
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.strtShopping();
		String CheckError = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		assertEquals(CheckError,"Products");
	}
	@Test(priority = 1)
	public void FillForm_ErrorValidation() throws InterruptedException {
		formPage.setCountrySelection("Aruba");
		formPage.setGender("female");
		formPage.strtShopping();
		String CheckError = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Please enter your name\"]")).getText();
		assertEquals(CheckError,"Please enter your name");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String,String>> Data = getJsonData(System.getProperty("user.dir")+ "\\src\\test\\java\\org\\rahulshetty\\testData\\Data.json");
		return new Object[][] { {Data.get(0)} , {Data.get(1)} };
	}
}

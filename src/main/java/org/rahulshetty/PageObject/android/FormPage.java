package org.rahulshetty.PageObject.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshetty.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	/**	NAMEFIELD **/
	private WebElement nameField;
	
	/******************** GENDER *****************************************/	
	/**	FEMALE OPTION **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	
	/** MALE OPTION **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	/** NATIONALITY **/
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	/** START SHOPPING BUTTON**/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement ShoppingBtn;
	
	public void setCountrySelection(String countryName) throws InterruptedException {
		countrySelection.click();
		scrollToText(countryName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+countryName +"\"]")).click();
	}
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if (gender.contains("female"))
			femaleOption.click();
		else if (gender.contains("male"))
			maleOption.click();
	}
	
	public void strtShopping() throws InterruptedException {
		ShoppingBtn.click();
		Thread.sleep(1000);
	}
	
}

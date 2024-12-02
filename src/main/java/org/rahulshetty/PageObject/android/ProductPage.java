package org.rahulshetty.PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshetty.Utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidActions{
	AndroidDriver driver;
	
	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/** BackBtn **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
	private WebElement BckBtn;
	
	/** CartBtn **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement CrtBtn;
	
	/** AddToCartBtn **/
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> AddToCrtBtn;
	
	
	public void AddItemsToCartByIndex(int Index) {
		AddToCrtBtn.get(Index).click();
	}
	
	public void GoToBackPage() {
		BckBtn.click();
	}
	
	public void CheckCart() throws InterruptedException {
		CrtBtn.click();
		Thread.sleep(2000);
	}
}

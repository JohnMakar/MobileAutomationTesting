package org.rahulshetty.PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshetty.Utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**	SendEmailCheckBox **/
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private WebElement SendEmailChckBx;
	
	/**	CompletePurchaseBtn **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement CompltePurchBtn;
	
	/** ProductPrice **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> ProductsPriceList;
	
	/** Total Amount **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement TotalAmount;
	
	
	/** TermsBtn **/
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement TrmsBtn;
	
	/** CloseTermsBtn **/
	@AndroidFindBy(id = "android:id/button1")
	private WebElement CloseTrms;
	
	public double CalculateTotalSum() {
		int productPricesCount = ProductsPriceList.size();
		System.out.println("TotalItemsIs: " + productPricesCount);
		double totalSum = 0;
		for (int i = 0; i < productPricesCount; i++) {
			String AmountString = ProductsPriceList.get(i).getText();
			double price = GetFormattedAmount(AmountString);
			totalSum = (int) (totalSum + price);
		}
		return totalSum;
	}
	
	public double GetTotalAmountDisplayed() {
		return GetFormattedAmount(TotalAmount.getText());
	}
	
	public void ShowTerms() throws InterruptedException {
		longPressAction(TrmsBtn);
		Thread.sleep(2000);
		CloseTrms.click();
	}
	
	public void CheckMailCheckBox() {
		SendEmailChckBx.click();
	}
}

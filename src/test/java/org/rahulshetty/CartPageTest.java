package org.rahulshetty;

import org.rahulshetty.PageObject.android.CartPage;
import org.rahulshetty.PageObject.android.FormPage;
import org.rahulshetty.PageObject.android.ProductPage;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass{

	@Test
	public void TestCart() throws InterruptedException {
		FormPage formPage = new FormPage(driver);
		formPage.setCountrySelection("Belgium");
		formPage.setNameField("John");
		formPage.setGender("male");
		formPage.strtShopping();
		ProductPage productPage = new ProductPage(driver);
		productPage.AddItemsToCartByIndex(0);
		formPage.scrollToText("Converse All Star");
		productPage.AddItemsToCartByIndex(0);
		productPage.CheckCart();
		CartPage cartPage = new CartPage(driver);
		double GetTotalSum = cartPage.CalculateTotalSum();
		double GetTotalAmount = cartPage.GetTotalAmountDisplayed();
		System.out.println(GetTotalAmount);
		System.out.println(GetTotalSum);
		cartPage.ShowTerms();
		cartPage.CheckMailCheckBox();
	}
}

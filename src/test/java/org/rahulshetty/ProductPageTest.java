package org.rahulshetty;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshetty.PageObject.android.FormPage;
import org.rahulshetty.PageObject.android.ProductPage;
import org.testng.annotations.Test;


public class ProductPageTest extends BaseClass{
	WebDriverWait wait ;
	@Test
	public void productTest() throws InterruptedException {
		FormPage formPage = new FormPage(driver);
		formPage.setCountrySelection("Aruba");
		formPage.setNameField("John");
		formPage.setGender("male");
		formPage.strtShopping();
		ProductPage productPage = new ProductPage(driver);
		productPage.AddItemsToCartByIndex(0);
		formPage.scrollToText("Converse All Star");
		productPage.AddItemsToCartByIndex(0);
		productPage.CheckCart();
		String CheckError = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		assertEquals(CheckError,"Cart");
	}
	@Test
	public void ProductTest_ValidationMsg() throws InterruptedException{
		FormPage formPage = new FormPage(driver);
		formPage.setCountrySelection("Albania");
		formPage.setNameField("John");
		formPage.setGender("male");
		formPage.strtShopping();
		ProductPage productPage = new ProductPage(driver);
		productPage.CheckCart();
		wait = new WebDriverWait(driver,Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[@text=\"Toast message\"]")));
		String CheckError = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Toast message\"]")).getAttribute("displayed");
		assertEquals(CheckError,"False","CartPageIsNotOpened");
	}

}

package com.qapropsoft.carina.demo.gui.pages.desktop;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
	@FindBy(css = "td[class='product-name'] a")
	private ExtendedWebElement productNameFld;
	@FindBy(css = "input[type=\"number\"]")
	private ExtendedWebElement productQuantityFld;
	@FindBy(css = ".checkout-button")
	private ExtendedWebElement proceedToCheckoutBtn;
	@FindBy(css = "a[title='View cart']")
	private ExtendedWebElement viewCartLink;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CartPage getProductNameTxt(String str1) {
		String str = productNameFld.getText();
		assertElementPresent(productNameFld);
		Assert.assertEquals(str, str1);
		return this;
	}

	public CartPage getProductnQuantity(String str) {
		String strQuantity = productQuantityFld.getAttribute("value");
		Assert.assertEquals(str, strQuantity);
		assertElementPresent(productNameFld);
		return this;
	}

	public CartPageBase productGetTextName(String s1) {
		return getProductNameTxt(s1);
	}

	public CartPageBase productGetProductQuantity(String q1) {
		return getProductnQuantity(q1);
	}

}

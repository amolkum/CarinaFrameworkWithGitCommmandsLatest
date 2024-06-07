package com.qapropsoft.carina.demo.gui.pages.desktop;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;


public abstract class CheckOutPageBase extends AbstractPage {
	protected CheckOutPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract CheckOutPageBase enterBillingFirstName(String billingFirstName);

	public abstract CheckOutPageBase enterBillingLastName(String billingLastName);

	public abstract CheckOutPageBase enterBillingAddressLineOne(String billingAddressLineOne);

	public abstract CheckOutPageBase enterBillingCity(String billingCity);

	public abstract CheckOutPageBase selectBillingState(String billingStateName);

	public abstract CheckOutPageBase enterBillingZip(String billingZip);

	public abstract CheckOutPageBase enterBillingEmail(String billingEmail);

	public abstract CheckOutPageBase setBillingDetails(BillingDetails billingDetails);

	public abstract CheckOutPageBase placeOrder();
}

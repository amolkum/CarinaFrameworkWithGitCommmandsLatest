package com.qapropsoft.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class StorePageBase extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public StorePageBase(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
	}

	@Override
	public void open() {
		super.open();
	}

	public abstract StorePageBase clickStoreLinkButton();

	public abstract StorePageBase addToCart(String productName);

	public abstract StorePageBase clickProceedToCheckOutPage();

	public abstract StorePageBase enterBillingFirstName(String billingFirstName);

	public abstract StorePageBase enterBillingLastName(String billingLastName);

	public abstract StorePageBase enterBillingAddressLineOne(String billingAddressLineOne);

	public abstract StorePageBase enterBillingCity(String billingCity);

	public abstract StorePageBase selectBillingState(String billingStateName);

	public abstract StorePageBase enterBillingZip(String billingZip);

	public abstract StorePageBase enterBillingEmail(String billingEmail);

	public abstract StorePageBase setBillingDetails(BillingDetails billingDetails);

	public abstract StorePageBase placeOrder();

	public abstract String getNotice();

}

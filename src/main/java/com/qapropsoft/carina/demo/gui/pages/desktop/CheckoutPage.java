package com.qapropsoft.carina.demo.gui.pages.desktop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class CheckoutPage extends CheckOutPageBase implements IDriverPool {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "billing_first_name")
	private ExtendedWebElement billingFirstnameFld;
	@FindBy(id = "billing_last_name")
	private ExtendedWebElement billingLastNameFld;
	@FindBy(id = "billing_address_1")
	private ExtendedWebElement billingAddressOneFld;
	@FindBy(id = "billing_city")
	private ExtendedWebElement billingCityFld;
	@FindBy(id = "billing_state")
	private ExtendedWebElement billingStateDropDown;
	@FindBy(id = "select2-billing_state-container")
	private ExtendedWebElement alternateBillingStateDropDown;
	@FindBy(id = "billing_postcode")
	private ExtendedWebElement billingZipFld;
	@FindBy(id = "billing_email")
	private ExtendedWebElement billingEmailFld;
	@FindBy(id = "place_order")
	private ExtendedWebElement placeOrderBtn;
	@FindBy(css = ".woocommerce-notice")
	private ExtendedWebElement noticeTxt;
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");
	WebDriverWait wait;

	public CheckoutPage enterBillingFirstName(String billingFirstName) {
		assertElementPresent(billingFirstnameFld);
		billingFirstnameFld.type(billingFirstName);
		return this;
	}

	public CheckoutPage enterBillingLastName(String billingLastName) {
		assertElementPresent(billingLastNameFld);
		billingLastNameFld.type(billingLastName);
		return this;
	}

	public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne) {
		assertElementPresent(billingAddressOneFld);
		billingAddressOneFld.type(billingAddressLineOne);
		return this;
	}

	public CheckoutPage enterBillingCity(String billingCity) {
		assertElementPresent(billingCityFld);
		billingCityFld.type(billingCity);
		return this;
	}

	public CheckoutPage selectBillingState(String billingStateName) {
		alternateBillingStateDropDown.isVisible();
		alternateBillingStateDropDown.click();
		alternateBillingStateDropDown.clickByJs();
//		wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
//		WebElement e = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + billingStateName + "']")));
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", e);
//		e.click();
		return this;
	}

	public CheckoutPage enterBillingZip(String billingZip) {
		assertElementPresent(billingZipFld);
		billingZipFld.type(billingZip);
		return this;
	}

	public CheckoutPage enterBillingEmail(String billingEmail) {
		assertElementPresent(billingEmailFld);
		billingEmailFld.type(billingEmail);
		return this;
	}

	public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
		return enterBillingFirstName(billingDetails.getBillingFirstName())
				.enterBillingLastName(billingDetails.getBillingLastName())
				.enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
				.enterBillingCity(billingDetails.getBillingCity())
				.selectBillingState(billingDetails.getBillingStateName())
				.enterBillingZip(billingDetails.getBillingZip()).enterBillingEmail(billingDetails.getBillingEmail());
	}

	public CheckoutPage placeOrder() {
		placeOrderBtn.isVisible();
		assertElementPresent(placeOrderBtn);
		placeOrderBtn.click();
		return this;
	}

	public String getNotice() {
		return noticeTxt.getText();

	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = getDriver().findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			// wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}
}

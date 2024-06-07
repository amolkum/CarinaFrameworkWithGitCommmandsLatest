package com.qapropsoft.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.joda.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = StorePageBase.class)
public class StorePage extends StorePageBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	@FindBy(xpath = "(//a[contains(text(),'Store')])[1]")
	private ExtendedWebElement storeLinkElement;
	@FindBy(css = "td[class='product-name'] a")
	private ExtendedWebElement productNameFld;
	@FindBy(css = "input[type=\"number\"]")
	private ExtendedWebElement productQuantityFld;
	@FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
	private ExtendedWebElement anchorBraceLetElementAddToCart;
	@FindBy(css = "a[title='View cart']")
	private ExtendedWebElement viewCartLink;
	@FindBy(xpath = "//h1[normalize-space()='Store']")
	private ExtendedWebElement titleTxt;
	@FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
	private ExtendedWebElement proceedToCheckOutBtnElement;
	protected WebDriverWait wait;
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

	public StorePage(WebDriver driver) {

		super(driver);
	}

	public StorePage clickStoreLinkButton() {
		assertElementPresent(storeLinkElement);
		storeLinkElement.click();
		return this;
	}

	@Override
	public StorePage addToCart(String productName) {
		String raw = "a[aria-label='Add “" + productName + "” to your cart']";
		byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
		String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);
		By addToCartBtn = By.cssSelector(utf8Encoded);
		WebElement ele =getDriver().findElement(addToCartBtn);
		String str2 = ele.getText();
		System.out.println("The element text is :" + str2);
		assertElementPresent(titleTxt);
		ele.click();
		viewCartLink.click();
		return this;
	}

	public StorePage clickProceedToCheckOutPage() {
		assertElementPresent(proceedToCheckOutBtnElement);
		proceedToCheckOutBtnElement.click();
		return this;
	}

	public StorePage enterBillingFirstName(String list) {
		billingFirstnameFld.type(list);
		return this;
	}

	public StorePage enterBillingLastName(String billingLastName) {

		billingLastNameFld.type(billingLastName);
		return this;
	}

	public StorePage enterBillingAddressLineOne(String billingAddressLineOne) {
		billingAddressOneFld.type(billingAddressLineOne);
		return this;
	}

	public StorePage enterBillingCity(String billingCity) {
		billingCityFld.type(billingCity);
		return this;
	}

	public StorePage selectBillingState(String billingStateName) {
		alternateBillingStateDropDown.click();
		return this;
	}

	public StorePage enterBillingZip(String billingZip) {
		billingZipFld.type(billingZip);
		return this;
	}

	public StorePage enterBillingEmail(String billingEmail) {
		billingEmailFld.type(billingEmail);
		return this;
	}

	public StorePage setBillingDetails(BillingDetails billingDetails) {
		return enterBillingFirstName(billingDetails.getBillingFirstName())
				.enterBillingLastName(billingDetails.getBillingLastName())
				.enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
				.enterBillingCity(billingDetails.getBillingCity())
				.selectBillingState(billingDetails.getBillingStateName())
				.enterBillingZip(billingDetails.getBillingZip()).enterBillingEmail(billingDetails.getBillingEmail());
	}

	public StorePage placeOrder() {
		placeOrderBtn.isVisible();
		placeOrderBtn.click();
		return this;
	}

	public String getNotice() {
		noticeTxt.isVisible();
		return noticeTxt.getText();
	}

	public void getProductQuantity() {
		productQuantityFld.getAttribute(String.valueOf(productQuantityFld));
	}
}

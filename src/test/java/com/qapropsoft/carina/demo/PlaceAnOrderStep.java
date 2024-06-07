package com.qapropsoft.carina.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.qapropsoft.carina.demo.gui.pages.desktop.BillingDetails;
import com.qapropsoft.carina.demo.gui.pages.desktop.CartPage;
import com.qapropsoft.carina.demo.gui.pages.desktop.CartPageBase;
import com.qapropsoft.carina.demo.gui.pages.desktop.CheckOutPageBase;
import com.qapropsoft.carina.demo.gui.pages.desktop.CheckoutPage;
import com.qapropsoft.carina.demo.gui.pages.desktop.StorePage;
import com.qapropsoft.carina.demo.gui.pages.desktop.StorePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceAnOrderStep implements IAbstractTest {
	private final CheckoutPage checkoutPage = new CheckoutPage(getDriver());
	CheckOutPageBase checkOutPageBase;
	List<List<String>> list = new ArrayList<List<String>>();
	StorePage storePage = new StorePage(getDriver());
	StorePageBase storePageBase;

	@Given("I'm a guest customer")
	public void i_m_a_guest_customer() {
		System.out.println("Start1--------------");
		System.out.println("Step 1");
		storePageBase = initPage(getDriver(), StorePageBase.class);
		storePageBase.open();
	}

	@Given("my billing details are")
	public void my_billing_details_are(DataTable table) {
		System.out.println("Start2--------------");
		System.out.println("Step 2");
		list = table.asLists(String.class);

		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				list.get(i).get(j);
				System.out.println("The list values are :" + list.get(i).get(j));
			}
		}
	}

	@Given("I have a product in the cart")
	public void i_have_a_product_in_the_cart() {
		System.out.println("Start3--------------");
		System.out.println("<------Step 3------>");
		storePageBase = storePage.clickStoreLinkButton();
		storePageBase = storePage.addToCart("Blue Shoes");
	}

	@Given("I'm on the Checkout page")
	public void i_m_on_the_Checkout_page() {
		System.out.println("Start4--------------");
		System.out.println("<------Step 4------>");
		storePage.clickProceedToCheckOutPage();

	}

	@When("I provide billing details")
	public void i_provide_billing_details() {
		System.out.println("Start5--------------");
		System.out.println("<------Step 5------>");
		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				checkoutPage.enterBillingFirstName(list.get(i).get(j));
				checkoutPage.enterBillingLastName(list.get(i).get(j + 1));
				checkoutPage.enterBillingAddressLineOne(list.get(i).get(j + 3));
				checkoutPage.enterBillingCity(list.get(i).get(j + 4));
				checkoutPage.enterBillingZip(list.get(i).get(j + 6));
				checkoutPage.enterBillingEmail(list.get(i).get(j + 7));
			}
		}
	}

	@When("I place an order")
	public void i_place_an_order() {
		System.out.println("Start6--------------");
		System.out.println("<------Step 6------>");
		checkoutPage.placeOrder();

	}

	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
		System.out.println("Start7--------------");
		System.out.println("<------Step 7------>");
		Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());

	}

	@Given("I have a product \"Blue-Shoes\"in the cart")
	public void i_have_a_product_Blue_Shoes_in_the_cart(String productName) {
		System.out.println("Start8--------------");
		storePageBase = storePage.clickStoreLinkButton();
		storePageBase = storePage.addToCart(productName);
	}

}

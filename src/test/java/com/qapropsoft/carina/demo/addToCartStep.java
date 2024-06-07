package com.qapropsoft.carina.demo;

import com.qapropsoft.carina.demo.gui.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;

import io.cucumber.java.en.*;

public class addToCartStep implements IAbstractTest {
	StorePage storePage = new StorePage(getDriver());
	CartPage cartPage = new CartPage(getDriver());
	StorePageBase storePageBase;
	CartPageBase cartPageBase;

	@Given("I am on the Store Page")
	public void i_am_on_the_Store_Page() {
		System.out.println("Start1--------------");
		System.out.println("The file is getting executed");
		storePageBase = new StorePage(getDriver());
		storePageBase.open();
	}

	@When("I add a {string} to the cart")
	public void i_add_a_to_the_cart(String productName) {
		System.out.println("Start2--------------");
		storePageBase = storePage.clickStoreLinkButton();
		storePageBase = storePage.addToCart(productName);
	}

	@Then("I should see {int} {string} in the cart")
	public void i_should_see_in_the_cart(Integer quantity, String product) {
		System.out.println("Start3--------------");
		String s = String.valueOf(quantity);
		cartPageBase = cartPage.productGetTextName(product);
		cartPageBase = cartPage.getProductnQuantity(s);
	}
}
package com.qapropsoft.carina.demo.gui.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CartPageBase extends AbstractPage {

	protected CartPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract CartPageBase productGetTextName(String s1);

	public abstract CartPageBase productGetProductQuantity(String q1);

}

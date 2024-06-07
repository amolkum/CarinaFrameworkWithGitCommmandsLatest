package com.qapropsoft.carina.demo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.zebrunner.carina.core.IAbstractTest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks implements IAbstractTest {

	@After
	public void tearDown(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			System.out.println("The scenario name is :" + scenario.getName());
		}
	}

}

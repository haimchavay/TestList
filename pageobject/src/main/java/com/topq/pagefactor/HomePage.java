package com.topq.pagefactor;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractSugerCrmPage {
	public HomePage(WebDriver driver_) throws Exception {
		super(driver_);
	}

	@Override
	protected void assertInPage() throws Exception {}
}

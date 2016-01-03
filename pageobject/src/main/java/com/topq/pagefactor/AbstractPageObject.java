package com.topq.pagefactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {
	protected final WebDriver m_driver;
	
	public AbstractPageObject(WebDriver driver_) throws Exception {
		m_driver = driver_;
		PageFactory.initElements(m_driver, this);
		assertInPage();
	}
	
	protected abstract void assertInPage() throws Exception;
}

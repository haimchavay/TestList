package com.topq.pagefactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractSugerCrmPage extends AbstractPageObject {
	@FindBy(id="grouptab_0")
	WebElement m_sales_item;
	
	public AbstractSugerCrmPage(WebDriver driver_) throws Exception {
		super(driver_);
		
	}
	public SalesSubMenuPage clickOnSealsItem() throws Exception {
		m_sales_item.click();
		return new SalesSubMenuPage(m_driver);
	}
}

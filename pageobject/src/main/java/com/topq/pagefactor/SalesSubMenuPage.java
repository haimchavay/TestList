package com.topq.pagefactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesSubMenuPage extends AbstractSugerCrmPage {
	@FindBy(id="moduleTab_0_Leads")
	WebElement m_leads_item;
	
	public SalesSubMenuPage(WebDriver driver_) throws Exception {
		super(driver_);
	}		
	public LeadsPage click0nLeadsItem() throws Exception {
		m_leads_item.click();
		return new LeadsPage(m_driver);
	}
	@Override
	protected void assertInPage() throws Exception {}
}

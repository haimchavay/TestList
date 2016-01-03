package com.topq.pagefactor;

import java.rmi.server.ExportException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.topq.pagefactor.CreatePage.Salutation;

public class LeadsPage extends AbstractPageObject{
	@FindBy(xpath="//img[@alt='Create Lead']")
	WebElement m_create_lead;
	
	@FindBy(xpath="//h2[contains(.,'Leads')]")
	WebElement m_title;
	
	@FindBy(id="search_name_basic")
	WebElement m_search_filed;
	
	@FindBy(id="search_form_submit")
	WebElement m_search_btn;
	
	public LeadsPage(WebDriver driver_) throws Exception {
		super(driver_);
	}	
	private void setSearchFiled(String name_to_search_) {
		m_search_filed.clear();
		m_search_filed.sendKeys(name_to_search_);
	}
	private void clickSearchBtn() {
		m_search_btn.click();
	}
	public LeadsPage serchInSearchFiled(String name_to_search_) {
		setSearchFiled(name_to_search_);
		clickSearchBtn();
		return this;
	}		
	public CreatePage clickCreate() throws Exception {
		m_create_lead.click();
		return new CreatePage(m_driver);
	}
	public String getTitleInLeads() {
		return m_title.getText();
	}
	@Override
	protected void assertInPage() {
		if( ! getTitleInLeads().contains("Search Leads") ) {	
			throw new AssertionError("LeadsPage did not load");
		}	
	} 	
	public void checkIfElementExist(String firstName_, String lastName_, Salutation gender_) throws Exception {
			String fullName = gender_.getValue() + " " + firstName_ + " " + lastName_;
			WebElement element = m_driver.findElement(By.xpath("//b[contains(.,'" + fullName + "')]"));						
			if( ! element.getText().equals(fullName) ) {
				throw new ExportException("not find the user");
			}
	}
}

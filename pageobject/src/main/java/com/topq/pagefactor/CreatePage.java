package com.topq.pagefactor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreatePage extends AbstractPageObject{	
	public enum Salutation {
		Mr("Mr."),Mrs("Mrs.");
		
		private String value;	
		private Salutation(String value_){
			value = value_;
		}
		
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
	}
	
	@FindBy(id="first_name")
	WebElement m_first_name;

	@FindBy(id="last_name")
	WebElement m_last_name;
	
	@FindBy(id="alt_checkbox")
	WebElement m_copy_adress;
	
	@FindBy(id="SAVE_HEADER")
	WebElement m_save;	
	
	@FindBy(xpath="//h2[contains(.,'Create')]")
	WebElement m_title;
			
	public CreatePage(WebDriver driver_) throws Exception {
		super(driver_);
	}
	private void setFirstName(String first_name_) {
		m_first_name.sendKeys(first_name_);
	}
	private void setLastName(String last_name_) {
		m_last_name.sendKeys(last_name_);
	}
	private void setGender(Salutation salutation) {
		Select selectSalutation = new Select(m_driver.findElement(By.id("salutation")));
		selectSalutation.selectByValue(salutation.getValue());
	}
	private void clickCopyAdressCheckBox() {
		m_copy_adress.click();
	}
	private void clickSave() {
		m_save.click();
	}
	private String getTitleInCreatePage() {
		return m_title.getText();
	}
	public HomePage fillDetails(String first_name_, String last_name_, Salutation gender_) throws Exception {
		setFirstName(first_name_);
		setLastName(last_name_);
		setGender(gender_);
		clickCopyAdressCheckBox();
		clickSave();
		return new HomePage(m_driver);
	}
	@Override
	protected void assertInPage() throws Exception {
		if( ! getTitleInCreatePage().contains("Create") ) {	
			throw new Exception("CreatePage did not load");
		}		
	}		
}

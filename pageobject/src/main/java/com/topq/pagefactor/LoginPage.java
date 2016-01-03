package com.topq.pagefactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {	
	@FindBy(id="user_name")
	WebElement m_user_name;	
	
	@FindBy(id="user_password")
	WebElement m_password;		
	
	@FindBy(id="login_button")
	WebElement m_login;
	
	@FindBy(xpath="//b[contains(.,'Welcome to')]")
	WebElement m_title;
	
	public LoginPage(WebDriver driver_) throws Exception {
		super(driver_);
	}		
	private void setUserName(String username_) {
		m_user_name.sendKeys(username_);
	}
	private void setUserPassword(String password_) {
		m_password.sendKeys(password_);
	}
	private void clickLogin() {
		m_login.click();
	}
	public String getTitleFromLogin() {
		return m_title.getText();
	}
	public HomePage toLogin(String username_, String password_) throws Exception {
		setUserName(username_);
		setUserPassword(password_);
		clickLogin();
		return new HomePage(m_driver);
	}
	@Override
	protected void assertInPage() throws Exception {	
		if( ! getTitleFromLogin().contains("Welcome to") ) {	
			throw new Exception("LoginPage did not load");
		}	
	}
}

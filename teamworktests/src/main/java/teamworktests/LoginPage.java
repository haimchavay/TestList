package teamworktests;

import org.openqa.selenium.*;

public class LoginPage extends AbstractPageObject {
	private By checkForgotPassword = By.id("fpass");
	private By userName 	 	   = By.id("userLogin");
	private By password 	 	   = By.id("password");
	private By login 		 	   = By.id("ordLoginSubmitBtn");
	
	public LoginPage(WebDriver driver_) {
		super(driver_);
		assertInPage();
	}

	@Override
	public void assertInPage() {	
		if(m_driver.findElements(checkForgotPassword).size() == 0){
			throw new AssertionError("loginPage did not load");
		}			
	}
	private void setUserName(String userName_) {
		m_driver.findElement(userName).sendKeys(userName_);
	}
	private void setPassword(String password_) {
		m_driver.findElement(password).sendKeys(password_);
	}
	private void clickOnLoginBtn() {
		m_driver.findElement(login).click();	 
	}
	public OverviewPage loginToOverviewPage(String userName_, String password_) {
		setUserName(userName_);
		setPassword(password_);
		clickOnLoginBtn();	
		return new OverviewPage(m_driver);
	}
}

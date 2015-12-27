package teamworktests;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageObject {
	protected final WebDriver m_driver;
	
	public AbstractPageObject(WebDriver driver_) {
		m_driver = driver_;
	}
	public abstract void assertInPage();		
}

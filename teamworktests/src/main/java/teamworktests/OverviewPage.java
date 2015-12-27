package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends AbstractMenuItemPage {
	private By checkPageTitle = By.id("pageTitle");
	
	public OverviewPage(WebDriver driver_) {
		super(driver_);
		assertInPage();
	}
	@Override
	public void assertInPage() {
		if(m_driver.findElements(checkPageTitle).size() == 0) {
			throw new AssertionError("overviewPage did not load");
		}
	}
}

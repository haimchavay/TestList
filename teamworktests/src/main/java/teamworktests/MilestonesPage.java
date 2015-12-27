package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends AbstractMenuItemPage {
	private By checkTitle = By.xpath("//h2[text()='Milestones']");
	
	public MilestonesPage(WebDriver driver_) {
		super(driver_);
		assertInPage();
	}
	
	@Override
	public void assertInPage() {
		if(m_driver.findElements(checkTitle).size() == 0) {
			throw new AssertionError("milestonesPage did not load");
		}
	}
}

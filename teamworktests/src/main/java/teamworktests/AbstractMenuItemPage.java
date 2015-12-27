package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractMenuItemPage extends AbstractPageObject{
	By itemTasks = By.cssSelector("a[href='projects/145467-webdriver-training/tasks']");
	By itemMilestones = By.cssSelector("a[href='projects/145467-webdriver-training/milestones']");
	By itemOverview = By.cssSelector("a[href='projects/145467-webdriver-training/overview']");
			
	public AbstractMenuItemPage(WebDriver driver_) {
		super(driver_);
	}
	protected OverviewPage clickOnOverViewItem() {
		m_driver.findElement(itemOverview).click();
		return new OverviewPage(m_driver);
	}
	protected TasksPage clickOnTasksItem() {
		m_driver.findElement(itemTasks).click();
		return new TasksPage(m_driver);
	}
	protected MilestonesPage clickOnMilestonesItem() {
		m_driver.findElement(itemMilestones).click();
		return new MilestonesPage(m_driver);
	}
}

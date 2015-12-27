package teamworktests;

import org.openqa.selenium.*;

public class NewTaskListPage extends AbstractPageObject{
	private By checkTitlePage  = By.xpath("//h2[contains(.,'New Task List')]");
	private By nameOfTaskList  = By.id("newTaskListName");
	private By addThisTaskList = By.id("btnCreateTaskList");
	
	public NewTaskListPage(WebDriver driver_) {
		super(driver_);	
		assertInPage();
	}
	
	@Override
	public void assertInPage() {
		if(m_driver.findElements(checkTitlePage).size() == 0) {
			throw new AssertionError("newTaskListPage did not load");
		}
	}
	private void setNameOfList(String nameList_) {
		m_driver.findElement(nameOfTaskList).sendKeys(nameList_);
	}
	private TasksPage clickOnAddThisTaskListBtn() {
		m_driver.findElement(addThisTaskList).click();
		return new TasksPage(m_driver);
	}	
	public TasksPage createNEWListTasks(String nameList_) {
		setNameOfList(nameList_);
		return clickOnAddThisTaskListBtn();	
	}
}

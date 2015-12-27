package teamworktests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class NewTaskPage extends AbstractPageObject{
	private By userName = By.xpath("//input[@placeholder='What needs to be done?']"
								 + "/../../../div/div/div/select[contains(.,'Anyone')]"); 
	
	public NewTaskPage(WebDriver driver_) {
		super(driver_);
	}
	@Override
	public void assertInPage() {
			
	}
	private void setNameOfTask(String nameOfTaskList_, String nameOfTask_) {
		By name = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../../"
		+ "div/div/div/div/div/div/div/div/div/form/div/div/div/widget-typeahead/div/span/input[@class='tt-query']");
		m_driver.findElement(name).sendKeys(nameOfTask_);
	}
	private void setUserName(String userName_) {
		WebElement element = m_driver.findElement(userName);
		Select selectUser = new Select(element);
		selectUser.selectByVisibleText(userName_);
	}
	private void clickSaveBtn(String nameOfTaskList_) {
		By save = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../../"
				+ "div/div/div/div/div/div/div/div/div/form/div/div/div/div/input[@value='Save my changes']");
		m_driver.findElement(save).click();
	}	
	public TasksPage addNewTask(String nameOfTaskList_, String nameOfTask_, String userName_) {
		setNameOfTask(nameOfTaskList_, nameOfTask_);
		setUserName(userName_);
		clickSaveBtn(nameOfTaskList_);
		return new TasksPage(m_driver);
	}
}

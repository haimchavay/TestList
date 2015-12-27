package teamworktests;

import org.openqa.selenium.*;

public class TasksPage extends AbstractMenuItemPage {
	private By checkPageTitle  = By.id("pageTitle");
	private By addTaskList	   = By.id("liBFOATL");
	private By isExist;
	private By addTheFirstTask;
	
	public TasksPage(WebDriver driver_) {
		super(driver_);
		assertInPage();
	}
	@Override
	public void assertInPage() {
		if(m_driver.findElements(checkPageTitle).size() == 0) {
			throw new AssertionError("tasksPage did not load");
		}
	}
	public NewTaskListPage clickOnAddTaskListBtn() {
		m_driver.findElement(addTaskList).click();	
		return new NewTaskListPage(m_driver);
	}
	private boolean isTaskListExist(String nameOfTaskList_) {
		isExist = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]");
		return (m_driver.findElements(isExist).size() != 0 ? true : false);	
	}
	private boolean isTasksListExist(String nameOfTaskList_) {
		if( ! isTaskListExist(nameOfTaskList_) ) {
			return false;
		}
		By checkTasksList = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../../"
		+ "div/div/div/div/div[@class='task topTask']");	
		return m_driver.findElements(checkTasksList).size() == 2 ? true : false;	
	}
	
	public NewTaskPage clickAddTheFirstTask(String nameOfTaskList_) {
		if( ! isTaskListExist(nameOfTaskList_) ) {
			throw new AssertionError("not found "+nameOfTaskList_);		
		}	
		addTheFirstTask = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../../div/div/div/div/div/button");
		m_driver.findElement(addTheFirstTask).click();	
		return new NewTaskPage(m_driver);	
	}
	private void clickOnOptionsItem(String nameOfTaskList_) {
		By beforeClick = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../div/a/span[@class='mid']");
		m_driver.findElement(beforeClick).click();
	}
	public TasksPage clickOnDeleteItem(String nameOfTaskList_) {					
		isExist = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]");
		m_driver.findElement(isExist).click();	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		By option = By.xpath("//i[@class='ico-project-options']");
		m_driver.findElement(option).click();	
		By delete = By.xpath("//i[@class='ico-trash icon-large']/..");
		m_driver.findElement(delete).click();
		
		return this;
	}
	public TasksPage clickAddTask(String nameOfTaskList_, String nameOfTask_, String userName_) {
		/* Because the overlay */
		clickOnOptionsItem(nameOfTaskList_);
		clickOnOptionsItem(nameOfTaskList_);			
		By addTask = By.xpath("//a[text()="+"'"+nameOfTaskList_+"'"+"]/../a[text()='Add a task']");
		m_driver.findElement(addTask).click();
		NewTaskPage newTaskPage = new NewTaskPage(m_driver);
		return newTaskPage.addNewTask(nameOfTaskList_, nameOfTask_, userName_);
	}  
	public TasksPage checkIfTaskListAndTasksListExist(String nameOfTaskList_) {		
		if( ! isTasksListExist(nameOfTaskList_) ) {
			throw new AssertionError(nameOfTaskList_+" and tasks not exist!!!");
		}	
		return this;
	}
}

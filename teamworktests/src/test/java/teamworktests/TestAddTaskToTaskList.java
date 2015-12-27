package teamworktests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestAddTaskToTaskList {
	private WebDriver m_driver;
	
	@BeforeMethod
	public void setup() {
		m_driver = new FirefoxDriver();
		m_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		m_driver.get("http://topq.teamwork.com");
	}
//	@AfterMethod
	public void exitApp() {
		m_driver.quit();
	}  
	@Test
	public void test1() {
		String taskListName 			= "list11";
		LoginPage loginPage 			= new LoginPage(m_driver);
		OverviewPage overviewPage	    = loginPage.loginToOverviewPage("fake10@fake.com", "fake");
		TasksPage tasksPage			    = overviewPage.clickOnTasksItem();
		NewTaskListPage newTaskListPage =  tasksPage.clickOnAddTaskListBtn();	
		
		tasksPage					    = newTaskListPage.createNEWListTasks(taskListName);
		NewTaskPage newTaskPage 		= tasksPage.clickAddTheFirstTask(taskListName);		
		tasksPage 						= newTaskPage.addNewTask(taskListName, "task1", "fake10 fake10 (me)");
		tasksPage 						= tasksPage.clickAddTask(taskListName, "task2", "fake10 fake10 (me)");
		MilestonesPage milestonesPage   = tasksPage.clickOnMilestonesItem();
		tasksPage 						= milestonesPage.clickOnTasksItem();
		tasksPage 						= tasksPage.checkIfTaskListAndTasksListExist(taskListName);
		tasksPage						= tasksPage.clickOnDeleteItem(taskListName);
	}
}

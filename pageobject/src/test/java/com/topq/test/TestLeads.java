package com.topq.test;

import java.util.concurrent.TimeUnit;
import com.topq.pagefactor.*;
import com.topq.pagefactor.CreatePage.Salutation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLeads {
	private WebDriver m_driver;
	
	@BeforeMethod
	public void setup() {
		m_driver = new FirefoxDriver();
		m_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		m_driver.get("http://localhost/suger");
	}
	@AfterMethod
	public void toQuit() {
		m_driver.quit();
	}
	@Test
	public void testCreateNewLead() throws Exception {
		LoginPage  loginPage  = new LoginPage(m_driver);			
		HomePage   homePage  = loginPage.toLogin("admin", "admin");			
		LeadsPage  leadsPage = homePage.clickOnSealsItem().click0nLeadsItem();		
					
		String firstName = "haim";
		String lastName = "chavay";
		Salutation gender = Salutation.Mr;
		
		CreatePage createpage = leadsPage.clickCreate();	
		homePage  = createpage.fillDetails(firstName, lastName, gender);
		leadsPage = homePage.clickOnSealsItem().click0nLeadsItem();
		leadsPage = leadsPage.serchInSearchFiled("chavay");
		leadsPage.checkIfElementExist(firstName, lastName, gender);		
	}  	
}

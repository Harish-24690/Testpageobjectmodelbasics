package test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.crm.accounts.CRMAccountsPage;

public class MainMenu {
	WebDriver driver;
	public MainMenu(WebDriver driver){
		this.driver = driver;
	}

	public void goToHome() {

	}

	public void goToLeads() {

	}

	public void goToContacts() {

	}

	public CRMAccountsPage goToAccounts() {
	
		//driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
       Page.click("Accounts_XPATH");
		return new CRMAccountsPage();
	}

	public void goToDeals() {

	}
	public void goToActivities(){
		
		
	}
	public void goToReports(){
		
		
	}
	public void goToAnalytics(){
		
	}
}

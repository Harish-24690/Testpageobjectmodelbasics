package test.crm.accounts;

import org.openqa.selenium.By;

import test.base.Page;

public class CRMAccountsPage extends Page{
	
	public CreateAccount goToCreateAccount(){
		
		click("createaccount_CSS");//driver.findElement(By.cssSelector("button[class='customPlusBtn crm-font-bold newwhitebtn cP']")).click();
		
		return new CreateAccount();
	}
	public void goTodropdown(){
		
		
	}
	public void goToAllAccounts(){
		
		
	}

}

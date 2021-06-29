package test.crm.accounts;

import org.openqa.selenium.By;

import test.base.Page;

public class CreateAccount extends Page {

	public void createAccount(String accountname) {

		type("accountname_CSS", accountname); // driver.findElement(By.cssSelector("input[data-colname='ACCOUNTNAME']")).sendKeys(accountname);
	}

}

package test.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import test.base.Page;
import test.crm.accounts.CRMAccountsPage;
import test.crm.accounts.CreateAccount;
import test.pages.ZohoApp;
import test.utilities.TestUtil;

public class CreateAccountTest {

	@Test
	(dataProviderClass= TestUtil.class , dataProvider="dp")
	public void createAccountTest(Hashtable<String , String>data) {

		ZohoApp zapp = new ZohoApp();
		zapp.onClickCrm();
		CRMAccountsPage accounts = Page.menu.goToAccounts();
		CreateAccount cap = accounts.goToCreateAccount();
		cap.createAccount(data.get("accountname"));

	}

}

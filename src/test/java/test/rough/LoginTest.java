package test.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.base.Page;
import test.crm.accounts.CRMAccountsPage;
import test.crm.accounts.CreateAccount;
import test.pages.HomePage;
import test.pages.LoginPage;
import test.pages.ZohoApp;

public class LoginTest {
	
	// Rough page from logintest
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
		HomePage home = new HomePage();
		
		LoginPage login =home.goToSignIn();     //page.goToFreeSignUp();
		
		
		//LoginPage login = new LoginPage();
		ZohoApp zapp=	login.doLogin("harishr24690@gmail.com" ,"harish9731332306");
		//ZohoApp zapp =  new ZohoApp();
		zapp.onClickCrm();
		CRMAccountsPage accounts = Page.menu.goToAccounts();
	    CreateAccount cap= 	 accounts.goToCreateAccount();
		 cap.createAccount("harish");
		
		
	}

}

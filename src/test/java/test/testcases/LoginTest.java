package test.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import test.pages.HomePage;
import test.pages.LoginPage;
import test.pages.ZohoApp;
import test.utilities.TestUtil;

public class LoginTest extends BaseTest {
	
  @Test(dataProviderClass=TestUtil.class , dataProvider="dp")
	public  void loginTest(Hashtable<String , String>data) { 
	  
	  

		HomePage home = new HomePage();
		LoginPage login = home.goToSignIn();
		//System.out.println(data.get("username"));
	    login.doLogin(data.get("username"), data.get("password"));
	    
	}

}

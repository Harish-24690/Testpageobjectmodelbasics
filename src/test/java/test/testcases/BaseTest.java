package test.testcases;

import org.testng.annotations.AfterSuite;

import test.base.Page;

public class BaseTest {
	
	@AfterSuite
	public void tearDown(){
		
		Page.quit();
	}

}

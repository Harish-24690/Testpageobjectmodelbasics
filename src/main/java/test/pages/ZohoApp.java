package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.base.Page;
import test.crm.home.CRMHomePage;

public class ZohoApp extends Page{
	
	
	
	
	public CRMHomePage onClickCrm(){
		
		driver.findElement(By.cssSelector("span[class='_logo-crm _logo-x96 zod-app-logo']")).click();
		
		return new CRMHomePage();
		
	}
	public void onClickSalesIq(){
		driver.findElement(By.cssSelector("span[class='_logo-salesiq _logo-x96 zod-app-logo']")).click();
		
		
	}
	public void onClickBooks(){
		
		
	}

}

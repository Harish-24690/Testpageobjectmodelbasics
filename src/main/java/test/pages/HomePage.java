package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.base.Page;

public class HomePage extends Page {
	
 
	
	public void goToFreeSignUp(){
		
		//driver.findElement(By.cssSelector("a[class='zh-signup']")).click();
		click("signup_CSS");
		}
	public LoginPage goToSignIn(){
		
		//driver.findElement(By.cssSelector("a[class='zh-login']")).click();
		click("login_CSS");
	
		return new LoginPage();
	}
	public void goTOContactSales(){
		
		//driver.findElement(By.cssSelector("a[class='zh-contact']")).click();
		click("contactsales_CSS");
		
	}
	public void goToSupport(){
		//driver.findElement(By.cssSelector("a[class='zh-support']")).click();
		click("support_CSS");
		
	}
	public void goToCustomers(){
		
		//driver.findElement(By.cssSelector("a[class='zh-customers']")).click();
		click("customers_CSS");
		
	}

}

package test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.base.Page;

public class LoginPage extends Page{
	
	    public ZohoApp doLogin(String username , String password){
		
		//driver.findElement(By.cssSelector("input[name='LOGIN_ID']")).sendKeys(username);
		//driver.findElement(By.cssSelector("#nextbtn")).click();
		//driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
		//driver.findElement(By.cssSelector("#nextbtn")).click();
		
	    	type("username_CSS",username);
	    	click("next_CSS");
	    	type("password_CSS",password);
	    	click("signin_CSS");
		return new ZohoApp();
		
		
	}
	

}

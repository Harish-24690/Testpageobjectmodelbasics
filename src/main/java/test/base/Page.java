package test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.listeners.CustomListeners;
import test.utilities.ExcelReader;
import test.utilities.TestUtil;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger LOGGER = LogManager.getLogger(Page.class.getName());
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestLoginExcel.xlsx");
	public static WebDriverWait wait;

	public static String browser;
	public static MainMenu menu;
 
	public Page(){
		if(driver==null){
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
				LOGGER.debug("config has been loaded");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				LOGGER.info("OR properties has been loaded ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jenkins setting 
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				browser = System.getenv("browser");
			}else {
				browser=config.getProperty("browser"); 
			}
			config.setProperty("browser", browser); 
			
			
			if (config.getProperty("browser").equals("firefox")) {
	             WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","C:\\Java program\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();

				} else if (config.getProperty("browser").equals("chrome")) {
			
			
		
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");

		driver =  new ChromeDriver(options);
		
		} else if (config.getProperty("browser").equals("ie")) {
			
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}

		driver.get(config.getProperty("testsiteurl"));
		LOGGER.debug("Navigated to " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menu =  new MainMenu(driver);
		}
	}

	public boolean isElementpresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;
		}
	}

	public static void click(String Locator){
		if(Locator.endsWith("_CSS")){
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).click();	
		}else if(Locator.endsWith("_XPATH")){
			driver.findElement(By.xpath(OR.getProperty(Locator))).click();
		}else if(Locator.endsWith("_ID")){
			driver.findElement(By.id(OR.getProperty(Locator))).click();
			
		}
		CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + Locator);
		
		
	}
	
	public static void type(String Locator,String Value){
		
		if(Locator.endsWith("_CSS")){
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(Value);
		}else if(Locator.endsWith("_XPATH")){
			driver.findElement(By.xpath(OR.getProperty(Locator))).sendKeys(Value);
		}else if(Locator.endsWith("_ID")){
			driver.findElement(By.id(OR.getProperty(Locator))).sendKeys(Value);
		}
		CustomListeners.testReport.get().log(Status.INFO, "Typing on :" +Locator+   "entering value :" +Value);
	}
	
	static WebElement dropdown;
	public void select(String Locator ,String Value){
		
		if(Locator.endsWith("_CSS")){
		dropdown=	driver.findElement(By.cssSelector(OR.getProperty(Locator)));
			
		}else if(Locator.endsWith("_XPATH")){
			dropdown= driver.findElement(By.xpath(OR.getProperty(Locator)));
		}else if(Locator.endsWith("_ID")){
			dropdown = driver.findElement(By.id(OR.getProperty(Locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(Value);
		CustomListeners.testReport.get().log(Status.INFO, " Typing on :" +Locator+   "Selected the value from dropdown :" +Value);
	}
	
	public  static void quit(){
		
		driver.quit();
	}
	
	public static void verifyEquals(String expected ,String actual) throws IOException{
		
	try{
		
		Assert.assertEquals(actual, expected);
	}catch(Throwable t){
		
		TestUtil.captureScreenshot();
	// ReportNG
		Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
							+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
	// Extent Reports
		CustomListeners.testReport.get().log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
	   //CustomListeners.testReport.get().log(Status.FAIL, CustomListeners.testReport.get().addScreenCaptureFromPath(TestUtil.screenshotName));
	}
		
		
	}
}

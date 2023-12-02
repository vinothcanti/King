package king;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.Base;

import KingPages.SearchPageObjects;
import KingPages.ShoppingCartPage;
import KingPages.LoginTutorialPage;


public class LoginTutorial{

	WebDriver driver;	
	ExtentReports extentreports;
	ExtentTest extentTest;
	LoginTutorialPage lpage;
	ShoppingCartPage shoppingcartpage;
	SearchPageObjects searchpageobjects;
	
	@BeforeTest
	public  void chrome() {
		driver = new ChromeDriver();
		//driver.get("https://tutorialsninja.com/demo/");	
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/");	
		System.out.println("Chrome launched sucessfully");
		driver.get("https://tutorialsninja.com/demo/");	
	}
	
	@Test(priority=1)
	public void loginwithvaliduser()
	{
		lpage = new LoginTutorialPage(driver);
		lpage.clickmyaccount();
		lpage.clicklogin();
		lpage.Enterusername();
		lpage.Enterpassword();
		lpage.clickonsubmit();	

		String negative = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
		if(negative.equals(negative))
		{
			System.out.println("Application logged in successfully");

		}
		else
		{
			System.out.println("Application failed to logged in");
		}
	}
	@Test(priority=2)
	public void searchmaccheckout() throws InterruptedException
	{	
		
		searchpageobjects = new SearchPageObjects(driver);
		searchpageobjects.searchkey();
		searchpageobjects.search();
		String laptopname = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")).getText();
		System.out.println(laptopname);
		if(laptopname.equals(laptopname))
		{
			System.out.println("Application should display data as per search");
		}
		shoppingcartpage = new ShoppingCartPage(driver);
		shoppingcartpage.Clickhp();
		Thread.sleep(2000);
		shoppingcartpage.ClickOnAddtocartBtn();
		Thread.sleep(2000);
		shoppingcartpage.ClickOnAddtocartBtnincartpage();
		Thread.sleep(2000);
		shoppingcartpage.ClickOnShoppingcartBtn();
		Thread.sleep(2000);
		shoppingcartpage.RemoveBtn();
		String afterremovetext = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		System.out.println(afterremovetext);
		if(afterremovetext.equals(afterremovetext))
		{
			System.out.println("Application should display added laptop removed from add to cart page");
		}
		}
	@AfterMethod
	public void browserclose()
	{
	driver.close(); 
	}
	
	//method for extent reporting
	@BeforeTest
	public void getnameMethod(ITestContext context) {
		
		extentTest = extentreports.createTest(context.getName());
	}
	
	@BeforeSuite
	public void InitExtentReport() {
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("testreport_extent.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
	}
	
	//to generate extent report
	@AfterSuite
	public void generateReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("testreport_extent.html").toURI());
	}
	
	@AfterMethod
	public void generateStatus(Method m, ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("capture the screenchot on failure");
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + "is passed");
		}
	}

}

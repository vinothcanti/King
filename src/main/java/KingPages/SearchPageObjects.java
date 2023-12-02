package KingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObjects {

	WebDriver driver;	

	//objects
	@FindBy(xpath= "//*[@id=\"search\"]/input")
	private  WebElement Searchkey;

	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private  WebElement Search;

	public SearchPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//Actions
	public void searchkey()
	{
		Searchkey.sendKeys("hp");
	}
	public void search()
	{
		Search.click();
	}	
}

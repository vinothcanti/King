package KingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(xpath ="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")
	private WebElement clicklaptop;
	
	@FindBy(xpath ="//*[@id=\"button-cart\"]")
	private  WebElement addtocart;
	//
	@FindBy(xpath ="//*[@id=\"cart-total\"]")
	private  WebElement addtocartincartpage;
	
	@FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	private  WebElement shoppingcart;
	
	@FindBy(xpath ="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]/i")
	private  WebElement remove;
	
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions

	public void Clickhp()
	{
		clicklaptop.click();
	}
	public void ClickOnAddtocartBtn()
	{
		addtocart.click();
	}
	public void ClickOnAddtocartBtnincartpage()
	{
		addtocartincartpage.click();
	}
	public void ClickOnShoppingcartBtn()
	{
		shoppingcart.click();
	}
	public void RemoveBtn()
	{
		remove.click();
	}
}

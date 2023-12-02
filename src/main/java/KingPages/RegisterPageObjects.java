package KingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects {

WebDriver driver;	
	
	//objects
	@FindBy(xpath= "//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")
	private  WebElement Myaccount;
	
	@FindBy(xpath= "//*[@id=\\\"top-links\\\"]/ul/li[2]/ul/li[1]/a")
	private  WebElement Register;
	
	@FindBy(id= "input-firstname")
	private  WebElement firstname;
	
	@FindBy(id= "input-lastname")
	private  WebElement lastname;
	
	@FindBy(id= "input-email")
	private  WebElement email;
	
	@FindBy(id= "input-telephone")
	private  WebElement telephone;
	
	@FindBy(id= "input-password")
	private  WebElement password;
	
	@FindBy(id= "input-confirm")
	private  WebElement confirmpassword;
	
	@FindBy(xpath= "//*[@id=\"content\"]/form/div/div/input[1]")
	private  WebElement Agree;
	
	@FindBy(xpath= "//*[@id=\"content\"]/form/div/div/input[2]")
	private  WebElement Agreeandcontinue;
	
	public RegisterPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void clickmyaccount()
	{
		Myaccount.click();
	}
	public void clickregister()
	{
		Register.click();
	}
	public  void Enterfirstname()
	{
		firstname.sendKeys("vinoth");
	}
	public  void Enterlastname()
	{
		lastname.sendKeys("raj");
	}
	public  void Enteremail()
	{
		email.sendKeys("demouserr23@gmail.com");
	}
	public  void Entertelephone()
	{
		telephone.sendKeys("8760055475");
	}
	public  void Enterpassword()
	{
		password.sendKeys("Test@1234");
	}
	public  void Enterconfirmpassword()
	{
		confirmpassword.sendKeys("Test@1234");
	}
	public  void clickagree()
	{
		Agree.click();
	}
	public  void clickonsubmit()
	{
		Agreeandcontinue.click();
	}
	}


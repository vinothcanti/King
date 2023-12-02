package king;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.get("https://tutorialsninja.com/demo/");	
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/");	
		System.out.println("Chrome launched sucessfully");
		driver.get("https://tutorialsninja.com/demo/");	
	}
	}



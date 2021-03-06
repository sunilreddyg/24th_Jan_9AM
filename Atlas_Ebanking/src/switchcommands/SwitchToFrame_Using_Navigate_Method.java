package switchcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToFrame_Using_Navigate_Method
{

	public static void main(String[] args) 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/account/trips?src=manageTrips");
		driver.manage().window().maximize();
		
		//navigating a frame using page info..
		driver.navigate().to("https://www.cleartrip.com/signinstatic/tripidlogin.shtml?popup=no&guest=true");
		
		//Locate Element under frame
		WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));
		Email.clear();
		Email.sendKeys("darshan@gmail.com");
		
		//navigate back to mainpage from frame..
		driver.navigate().back();
	}

}

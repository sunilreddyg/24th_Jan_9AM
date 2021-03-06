package findelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_ReadData_From_DynamicRow_And_SpecificCell 
{

	public static void main(String[] args) 
	{
		/*
		 * FAQ:--> Read data from dynamic row and specific Cells.
		 */
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://content.icicidirect.com/IdirectContent/Markets/MarketOverview.aspx");
		driver.manage().window().maximize();
		
		
		//Identif markets link
		WebElement Markets_link=driver.findElement(By.xpath("(//a[contains(.,'markets')])[1]"));
		Markets_link.click();
		
		//Idetnfiy Webtable
		WebElement table=driver.findElement(By.xpath("//div[@id='pnl_Bse']/table"));
				
		//Using tr tag identify list of rows under table
		List<WebElement> rows=table.findElements(By.tagName("tr"));
				
		//Size of TR tages
		int Rcount=rows.size();
		
		//Iterate Number of rows
		for (int i = 1; i < Rcount; i++)
		{
			//Target Dynamic Row
			WebElement DynamicRow=rows.get(i);
			
			//USing Dynamic row find list of cells available
			List<WebElement> cells=DynamicRow.findElements(By.tagName("td"));
			
			//Using list get selected cell values 
			String Company_Name=cells.get(0).getText();
			String High_Price=cells.get(3).getText();
			
			System.out.println(Company_Name+"    "+High_Price);
		}
		

	}

}

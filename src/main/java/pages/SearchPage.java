package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SearchPage {
	
	@FindBy(xpath="//div[@class='secondary']")
	private List<WebElement> sourceDestination;
	
	@FindBy(xpath="//div[@class='primary duration-emphasis']")
	private List<WebElement> duration;
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifySourceDestination(String src,String dest)
	{
		String srcDest=src+" - "+dest;
		System.out.println(srcDest);
		int cntr=0;
		int cntr1=0;
		for(WebElement e:sourceDestination)
		{
			try
			{
				if(e.getText().equalsIgnoreCase(srcDest))
				{
					cntr++;
				}
			}
			catch(Exception exp)
			{
				cntr1++;
			}
		}
		Reporter.log(cntr+" matching Source and Destination flights ",true);
		if(cntr1>0)
		{
			Reporter.log(cntr1+" not matching Source and Destination flights ",true);
			Assert.fail();
		}
		else if(cntr==0)
		{
			Reporter.log(cntr+" no matching flights found",true);
			Assert.fail();
		}
		
	}
	
	public void printSourceDestination()
	{
		for(WebElement w:sourceDestination)
		{
			Reporter.log(w.getText(),true);
		}
	}
	
	public void verifySearchPage(WebDriver driver)
	{

		try
		{
			if(driver.getTitle().contains(" Flights | Orbitz"))
			{
				Reporter.log("Search page is displayed",true);
			}
		}
		catch(Exception e)
		{
			Reporter.log("Search page is not displayed",true);
		}
	}
}

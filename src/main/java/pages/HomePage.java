package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {
	
	@FindBy(xpath="//span[text()='Flights']")
	private WebElement flights;
	
	@FindBy(id="flight-type-one-way-label")
	private WebElement oneWay;
	
	@FindBy(xpath="//input[@id='flight-origin']")
	private WebElement from;
	
	@FindBy(xpath="//input[@id='flight-destination']")
	private WebElement to;
	
	@FindBy(xpath="//button[@id='search-button']")
	private WebElement search;
	
	@FindBy(xpath="//input[@id='flight-departing']")
	private WebElement calender;
	
	@FindBy(xpath="//button[text()='30']")
	private WebElement day;
	
	@FindBy(xpath="//div[@class='multiLineDisplay']")
	private WebElement departureCode;
	
	@FindBy(xpath="//div[@class='multiLineDisplay']")
	private WebElement toCode;

	public String fromString;
	public String towardsString;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickFlights()
	{
		
		flights.click();
		
	}

	public void clickOneWay()
	{
		oneWay.click();
	}
	
	public void enterFrom(String fromAdd) throws InterruptedException 
	{
		from.sendKeys(fromAdd);
		
	}
	
	public void enterTo(String toAdd)
	{
		to.sendKeys(toAdd);
	}
	
	public void clickSearch()
	{
		search.click();
		
	}
	
	public void enterDateCalender(String date)
	{
		calender.sendKeys(date);

		calender.sendKeys(Keys.ENTER);
	}

	public void clickDeparture(String dept) throws InterruptedException  
	{
		enterFrom(dept);
		fromString=getDeptCityCode();
	}
	
	public void clickTo(String to) throws InterruptedException 
	{
		enterTo(to);
		towardsString=getArrivalCityCode();
	}
	
	
	public String getDeptCityCode() 
	{
		String code="";
		try
		{
			String s[]=departureCode.getText().split(" ");
			code=s[1].substring(7, s[1].length()-1);
			
		}
		catch(Exception e)
		{
			from.sendKeys(" ");
			
		}
		return code;
		
	}
	
	public String getArrivalCityCode() throws InterruptedException
	{
		String ccode="";
		try
		{
			Thread.sleep(1000);
			String s[]=toCode.getText().split(" ");
			ccode=s[7].substring(7, s[7].length()-1);
		}
		catch(Exception e)
		{
			from.sendKeys(" ");
		}
		return ccode;
		
	}
	
	public void verifyHomePage(WebDriver driver)
	{
		try
		{
			if(driver.getTitle().equalsIgnoreCase("ORBITZ.com – Best Travel Deals"))
			{
				Reporter.log("Home page is displayed",true);
			}
		}
		catch(Exception e)
		{
			Reporter.log("Home page is not displayed",true);
		}
	}
		
}

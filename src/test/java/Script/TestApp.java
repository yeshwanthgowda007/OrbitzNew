package Script;


import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;
import resources.BaseClassTest;


public class TestApp extends BaseClassTest {
	
//	author="yash"
	@Test
	public void testApp() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.verifyHomePage(driver);
		home.clickFlights();
		home.clickOneWay();
		home.clickDeparture("chennai");
		home.clickTo("bangalore");
		home.enterDateCalender("02/15/2018");
		SearchPage search=new SearchPage(driver);
		search.verifySearchPage(driver);
		search.verifySourceDestination(home.fromString,home.towardsString);
		
	}
		

}

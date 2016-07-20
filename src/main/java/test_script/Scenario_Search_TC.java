package test_script;

import generic.BaseClass;
import org.testng.annotations.Test;
import pageObjectModel.Home_PageFactory;

public class Scenario_Search_TC extends BaseClass {
	Home_PageFactory home = null;
	@Test(dataProvider = "DP_validSeach", dataProviderClass = dataProvider.Search_DataProvider.class ,groups = {"Smoke","Regression"})
	public void validSearch(String TC_ID, String Order, String search_keyword, String Exp_Res)
	{
		home = new Home_PageFactory(driver);
		home.bookSearch(search_keyword);
		String actual = home.getValidSearchMessage();
		if(actual.equalsIgnoreCase(Exp_Res.replace(".0", "")))
		{
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC Fail");
		}
	}
	
	@Test(dataProvider = "DP_invalidSeach", dataProviderClass = dataProvider.Search_DataProvider.class,groups = {"Regression"})
	public void invalidSearch(String TC_ID, String Order, String search_keyword, String Exp_Res)
	{
		home = new Home_PageFactory(driver);
		home.bookSearch(search_keyword);
		String actual = home.getInvalidSearchMessage();
		if(actual.equalsIgnoreCase(Exp_Res))
		{
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC Fail");
		}
	}

}

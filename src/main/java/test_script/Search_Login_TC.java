package test_script;

import generic.BaseClass;
import org.testng.annotations.Test;
import pageObjectModel.Home_PageFactory;
import pageObjectModel.Login_PageFactory;

public class Search_Login_TC extends BaseClass{
	Home_PageFactory home = null;
	Login_PageFactory login = null;
	@Test(dataProvider = "DP_invalidLogin", dataProviderClass = dataProvider.Login_DataProvider.class, groups={"Regression"})
	public void Invalid_Login_test(String TC_ID, String Order, String uname, String pwd, String Exp_Res)
	{
		
		home = new Home_PageFactory(driver);
		home.clickSignIn();
		login = new Login_PageFactory(driver);
		login.userLogin(uname, pwd);
		String actual = login.getInvalidLoginText() ;
		if(actual.split(" ")[0].equalsIgnoreCase(Exp_Res))
		{
			System.out.println("TC pass");
		}
		else
		{
			System.out.println("TC fail , the actual is "+actual.split(" ")[0]);
		}
		driver.close();
	}
	
	@Test(dataProvider = "DP_validLogin", dataProviderClass = dataProvider.Login_DataProvider.class, groups = {"Smoke","Regression"})
	public void Valid_Login_test(String TC_ID, String Order, String uname, String pwd, String Exp_Res)
	{
				
		home = new Home_PageFactory(driver);
		home.clickSignIn();
		login = new Login_PageFactory(driver);
		login.userLogin(uname, pwd);
		String actual = login.getValidLoginText();
		if(actual.equalsIgnoreCase(Exp_Res))
		{
			System.out.println("TC pass");
		}
		else
		{
			System.out.println("TC fail");
		}
		
	}

}

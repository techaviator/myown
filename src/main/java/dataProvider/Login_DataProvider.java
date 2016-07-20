package dataProvider;

import generic.ExcelReader;
import generic.UtilClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Login_DataProvider {
	
	@DataProvider (name="DP_invalidLogin")
	public static Object[][] invalidLogin()
	{
		
		
		List<String> ls = getXLData("Invalid_Login_test");
		
		Object[][] obj = new Object[ls.size()][5];
		for(int i=0;i<ls.size();i++)
		{
			obj[i][0] = ls.get(i).split(";")[0];
			obj[i][1] = ls.get(i).split(";")[1];
			obj[i][2] = ls.get(i).split(";")[2];
			obj[i][3] = ls.get(i).split(";")[3];
			obj[i][4] = ls.get(i).split(";")[4];			
		}		
		return obj;
	}
	
	@DataProvider(name="DP_validLogin")
	public static Object[][] validLogin()
	{
		
		
		List<String> ls = getXLData("Valid_Login_test");
		
		Object[][] obj = new Object[ls.size()][5];
		
		for(int i=0;i<ls.size();i++)
		{
			obj[i][0] = ls.get(i).split(";")[0];
			obj[i][1] = ls.get(i).split(";")[1];
			obj[i][2] = ls.get(i).split(";")[2];
			obj[i][3] = ls.get(i).split(";")[3];
			obj[i][4] = ls.get(i).split(";")[4];			
		}		
		return obj;
	}
	
	public static List<String> getXLData(String scriptname)
	{
		ExcelReader xl = new ExcelReader(UtilClass.getConfigFileInfo("XLpath"));
		String sheetname = "Scenario_Login";
		int xlRowCount = xl.getXLRowCount(sheetname);
		List<String> ls = new ArrayList<String>();
		
		for(int i = 1;i<xlRowCount;i++)
		{
			if((xl.readXLData(sheetname, i, "Execute_Flag").equalsIgnoreCase("Y"))&&(xl.readXLData(sheetname, i, "Scriptname").equalsIgnoreCase(scriptname)))
			{
				String TC_ID = xl.readXLData(sheetname, i, "TC_ID");
				String Order = xl.readXLData(sheetname, i, "Order");
				String Uname = xl.readXLData(sheetname, i, "Uname");
				String Pwd = xl.readXLData(sheetname, i, "Pwd");
				String Exp_Res = xl.readXLData(sheetname, i, "Exp_Res");
				ls.add(TC_ID+";"+Order+";"+Uname+";"+Pwd+";"+Exp_Res);
				
			}
		}
		
		return ls;
		
	}

}

package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver  = null;
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void launchBrowser()
	{
		System.out.println("Initialize browser");
		String browserType = UtilClass.getConfigFileInfo("browsertype");		
		
		if(browserType.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
			
		if(browserType.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(UtilClass.getConfigFileInfo("URL"));
		
	}
	
	@AfterMethod(groups = {"Smoke","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public void getScreenshot(String TC_ID,String Order)
	{
		File file = new File(UtilClass.getConfigFileInfo("Screenshot")+TC_ID+"_"+Order+".txt");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

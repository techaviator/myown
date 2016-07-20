package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_PageFactory {
	
	WebDriver driver = null;
	@FindBy(linkText = "Sign In")
	private WebElement SignInLink;
	
	
	
	@FindBy(id = "srchword")
	private WebElement SearchwordTextbox;
	@FindBy(className = "newsrchbtn")
	private WebElement SearchButton;
	@FindBy(id = "find")
	private WebElement ValidSearchText;
	
	@FindBy(className = "sorrymsg")
	private WebElement InvalidSearchText;
	
	public Home_PageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn()
	{
		 SignInLink.click();;
	}
	
	public void bookSearch(String Search_Keyword)
	{
		SearchwordTextbox.sendKeys(Search_Keyword);
		SearchButton.click();
	}
	
	public String getInvalidSearchMessage()
	{
		return InvalidSearchText.getText();
	}
	
	public String getValidSearchMessage()
	{
		return ValidSearchText.getText();
	}

}

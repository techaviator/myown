package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_PageFactory {
	
	public WebDriver driver = null;
	
	@FindBy (name="logid")
	private WebElement UserNameTextbox;
	
	@FindBy (name="pswd")
	private WebElement PasswordTextbox;
	
	
	@FindBy (css="td[class='sb1'] input")
	private WebElement LoginButton;
	
	@FindBy (xpath="//b[contains(text(),'Sorry')]")
	private WebElement InvalidLoginText;
	
	
	
	@FindBy (xpath="//span[@id='username']/a")
	private WebElement ValidLoginText;
	
	public Login_PageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String uname, String pwd)
	{
		UserNameTextbox.sendKeys(uname);
		PasswordTextbox.sendKeys(pwd);
		LoginButton.click();
	}
	
	public String getInvalidLoginText()
	{
		return InvalidLoginText.getText();
	}
	
	public String getValidLoginText()
	{
		return ValidLoginText.getText();
	}
	
	
	
}

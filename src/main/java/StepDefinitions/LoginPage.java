package StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Steps{
	
	public LoginPage() {
		super();
	}
	
	@FindBy(xpath="//input[@name='username']") 
	   WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']") 
	   WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@type='Submit']")
	WebElement clickButton;
	
	
	public void LoginUsername(String text) {
		
		TypeMethod(usernameTextbox, text);
		
	}
	
	public void LoginPassword(String text) {
		TypeMethod(passwordTextbox, text);
	}
	
	public void ClickLogin() {
		
		click(clickButton);
	}

}

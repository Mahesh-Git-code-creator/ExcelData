package StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotel extends Steps {

	public SelectHotel() {
		super();
	}

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	WebElement ClickRadioBox;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement submitOfHotel;
	
	public void selectHotelRadioBox() {
		
		click(ClickRadioBox);
		
	}
	
	public void SubmitHotel() {
		click(submitOfHotel);
	}

}

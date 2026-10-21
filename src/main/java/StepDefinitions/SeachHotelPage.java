package StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeachHotelPage extends Steps {

	public SeachHotelPage() {

		super();
	}

	@FindBy(xpath = "//select[@name='location']")
	WebElement LocationOfHotel;

	@FindBy(xpath = "//select[@name='hotels']")
	WebElement Hotels;

	@FindBy(xpath = "//select[@name='room_type']")
	WebElement RoomType;

	@FindBy(xpath = "//select[@name='room_nos']")
	WebElement NoOFRooms;

	@FindBy(xpath = "(//input[@class='date_pick'])[1]")
	WebElement DateOfPick;

	@FindBy(xpath = "//input[@id='datepick_out']")
	WebElement OutoFDate;

	@FindBy(xpath = "//select[@id='adult_room']")
	WebElement AdultRoom;

	@FindBy(xpath = "//select[@id='child_room']")
	WebElement childrensRoom;

	@FindBy(xpath = "//input[@id='Submit']")
	WebElement ClickOfSearchButton;
	
	

	public void searchHotel(String text) {

		SelectMethod(LocationOfHotel, text);

	}

	public void HotelOf(String text) {
		SelectMethod(Hotels, text);
	}

	public void TypeOfRoom(String text) {
		SelectMethod(RoomType, text);
	}

	public void SelectOfRooms(String text) {

		SelectMethod(NoOFRooms, text);

	}

	public void PickOfDate(String text) throws Exception {

		clear(DateOfPick);
		Thread.sleep(3000);
		TypeMethod(DateOfPick, text);
	}

	public void PickOfOutDated(String text) throws Exception {

		clear(OutoFDate);
		Thread.sleep(3000);
		TypeMethod(OutoFDate, text);
	}

	public void AdultRoom(String text) {

		SelectMethod(AdultRoom, text);

	}

	public void ChildrenRoom(String text) {

		SelectMethod(childrensRoom, text);
	}
	
	public void searchClickOf() {
		
		click(ClickOfSearchButton);
	}

}

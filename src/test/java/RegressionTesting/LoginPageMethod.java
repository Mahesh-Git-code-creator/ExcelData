package RegressionTesting;

import org.testng.annotations.Test;
import ChromeBrowser.BrowserPage;
import StepDefinitions.LoginPage;
import StepDefinitions.SeachHotelPage;
import StepDefinitions.SelectHotel;

public class LoginPageMethod extends BrowserPage {

	@Test

	public void LoginRegressionPage() throws Exception {

//		LoginPage loginpage =	PageFactory.initElements(driver, LoginPage.class);

		LoginPage page = new LoginPage();
		page.LoginUsername("kolluboinachinna");
		page.LoginPassword("MG5M6Q");
		page.ClickLogin();
		page.VerifyTitle("Adactin.com - Search Hotel");
		
		SeachHotelPage searhhotelpage =	new SeachHotelPage();
		
		searhhotelpage.searchHotel("London");
		searhhotelpage.HotelOf("Hotel Sunshine");
		searhhotelpage.TypeOfRoom("Double");
		searhhotelpage.SelectOfRooms("1 - One");
		searhhotelpage.PickOfDate("17/10/2026");
        searhhotelpage.PickOfOutDated("19/10/2026");
        searhhotelpage.AdultRoom("4 - Four");
        searhhotelpage.ChildrenRoom("2 - Two");
        searhhotelpage.searchClickOf();
        searhhotelpage.VerifyTitle("Adactin.com - Select Hotel");
        
 
        SelectHotel selecthotel =   new SelectHotel();
        selecthotel.selectHotelRadioBox();
        selecthotel.SubmitHotel();
		
	}

}

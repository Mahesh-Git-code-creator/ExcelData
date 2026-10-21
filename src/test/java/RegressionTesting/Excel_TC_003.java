package RegressionTesting;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ChatGPTsolution.ExcelRetrieveData;
import ChromeBrowser.BrowserPage;
import StepDefinitions.LoginPage;
import StepDefinitions.SeachHotelPage;

public class Excel_TC_003 extends BrowserPage {

	@Test(description = "Sucess Search HotelPage", dataProvider = "getSearchHotelPage")

	public void LoginRegressionPage(HashMap<String, String> DataHashmap) throws Exception {

//		LoginPage loginpage =	PageFactory.initElements(driver, LoginPage.class);

		LoginPage page = new LoginPage();

		page.LoginUsername(DataHashmap.get("Username"));
		page.LoginPassword(DataHashmap.get("Password"));
		page.ClickLogin();
		page.VerifyTitle(DataHashmap.get("Exp-Title"));

		SeachHotelPage searhhotelpage = new SeachHotelPage();

		searhhotelpage.searchHotel(DataHashmap.get("Location"));
		searhhotelpage.HotelOf(DataHashmap.get("Hotels"));
		searhhotelpage.TypeOfRoom(DataHashmap.get("Room Type"));
		searhhotelpage.SelectOfRooms(DataHashmap.get("SelectOfRooms"));
		searhhotelpage.PickOfDate(DataHashmap.get("ValidDate"));
		searhhotelpage.PickOfOutDated(DataHashmap.get("OutDated"));
		searhhotelpage.AdultRoom(DataHashmap.get("AdultRoom"));
		searhhotelpage.ChildrenRoom(DataHashmap.get("ChildrenRoom"));
		searhhotelpage.searchClickOf();
//        searhhotelpage.VerifyTitle(DataHashmap.get("VerifyTitle"));

	}

	@DataProvider
	public Object[][] getSearchHotelPage() throws IOException {

		Object[][] object = new Object[1][1];

//		object[0][0] = UtilPage.getDataExcel("TC-003");

		object[0][0] = ExcelRetrieveData.getDataExcel("TC-003");

		return object;

	}

}

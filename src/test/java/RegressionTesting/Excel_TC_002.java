package RegressionTesting;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ChatGPTsolution.ChatGPTValues;
import ChromeBrowser.BrowserPage;
import StepDefinitions.LoginPage;

public class Excel_TC_002 extends BrowserPage {

	@Test(description = "Success Login page", dataProvider = "getRetireveExcelData")

	public void LoginRegressionPage(HashMap<String, String> hMapping) {

		LoginPage page = new LoginPage();
		page.LoginUsername(hMapping.get("username"));
		page.LoginPassword(hMapping.get("Password"));
		page.ClickLogin();
		page.VerifyTitle(hMapping.get("Exp-Title"));

	}

	@DataProvider

	public Object[][] getRetireveExcelData() throws IOException {

		Object[][] object = new Object[1][1];
		
	object[0][0]=	ChatGPTValues.getDataRetriveExcel("TC-002");


		return object;

	}

}

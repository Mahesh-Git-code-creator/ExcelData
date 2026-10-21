package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ChromeBrowser.BrowserPage;

public class Steps extends BrowserPage {
	
	public Steps() {
		PageFactory.initElements(driver, this);
	}

	public void TypeMethod(WebElement element, String text) {

		waitForElement(element);
		
		ScrollPage("");

		element.sendKeys(text);

	}

	private void ScrollPage(String string) {
	 
		JavascriptExecutor Js = ((JavascriptExecutor)driver);
		Js.executeScript(string);
		
	}

	private void waitForElement(WebElement element) {

		WebDriverWait mywait = new WebDriverWait(driver,
				       Duration.ofSeconds(Long.parseLong(prop.getProperty("explicitwait"))));

		mywait.until(ExpectedConditions.visibilityOf(element));

	}

	public void click(WebElement element) {

		element.click();
	}

	public void clear(WebElement element) {

		element.clear();
	}
	
	public void SelectMethod(WebElement element,String text) {
		
		new Select(element).selectByVisibleText(text);
		
	}
	
	public String Title() {
		return driver.getTitle();
		
	}
	
	 public void VerifyTitle(String ExpTitle) {
		 
		 Assert.assertEquals(Title(), ExpTitle);
		 
	 }
	 
	 public void Screenshot(String path) throws IOException {
		 
		 File file =	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(file, new File(path));
		 
	 }
	 
	 @SuppressWarnings("unused")
	public void ActionClass(String element) {
		 
		 Actions actions = new Actions(driver);
		 
//		 actions.moveToElement(driver.findElement(By.xpath(element))).build().perform();
		 
//		 actions.contextClick(driver.findElement(By.xpath(element))).keyDown(element).keyDown(element).pause(3000).build().perform();
		 
	 }
	 
	 

}

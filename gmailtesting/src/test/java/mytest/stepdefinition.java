package mytest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import utils.CommonUtils;
import utils.DriverUtils;

public class stepdefinition extends CommonUtils{

	// TODO Auto-generated method stub
	public static WebDriver driver = null;

	private Scenario myScenario;

	@Before()
	public void embedScreenshotStep(Scenario scenario) {

		myScenario = scenario;
//		driver = DriverUtils.getDriver();
		driver = DriverUtils._driver;
	}

	@Given("^url opened$")
	public void url_opened() throws Throwable {
		String url = "https://mail.google.com";
		navigateToURL(url);
	}

	@Then("^enter user id and click next$")
	public void enter_user_id_and_click_next() throws Throwable {
		sendKeys(By.xpath("//input[@id='identifierId']"), "cbarath1986");
	//	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("cbarath1986");
		click(By.id("identifierNext"));
//		driver.findElement(By.id("identifierNext")).click();
//		Thread.sleep(2000);
	}

	@Then("^enter password$")
	public void enter_password() throws Throwable {
		sendKeys(By.xpath("//input[@name='password']"),"Se1f-respect");
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(password));
//		password.sendKeys("");

	}

	@Then("^click login$")
	public void click_login() throws Throwable {
		click(By.id("passwordNext"));
//		driver.findElement(By.id("passwordNext")).click();
//		Thread.sleep(6000);
		System.out.println(getPageTitle());
		myScenario.write("User loggedin successfully");
		//// byte[] screenshot =
		//// ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		// myScenario.embed(screenshot, "image/png"); // Stick it in the report
		zoomOut(2);
		myScenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}

	public void zoomIn(int num){
		for(int i=0; i<num; i++){
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
			}
			}

	public void zoomOut(int num){
		for(int i=0; i<num; i++){
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			}
			}

	public void set0(){
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			}
}

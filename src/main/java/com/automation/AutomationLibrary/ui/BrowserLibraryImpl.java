package com.automation.AutomationLibrary.ui;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

/**
 * @author Genpact Automation Team
 *
 */
public class BrowserLibraryImpl implements BrowserLibrary {

	private WebDriver driver;
	@Value("${implicitWait}")
	private int implicitWait;
	@Value("${webDriverWait}")
	private long webDriverWait;
	@Value("${browserDimension}")
	private String browserDimension;

	public BrowserLibraryImpl(WebdriverService webdriverService) {
		this.driver = webdriverService.getWebDriver();
	}

	/*
	 * public BrowserLibraryImpl(WebDriver driver,int implicitWait,String
	 * browserDimension) { this.driver = driver; this.implicitWait = implicitWait;
	 * this.browserDimension = browserDimension; }
	 */

	public void navigate(String url) {
		this.driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
		driver.navigate().to(url);
		driver.manage().window().maximize();
//	        try{
//	        	String browserDimensions[] = browserDimension.split(",");
//	        	driver.manage().window().setSize(new Dimension(Integer.valueOf(browserDimensions[0]), Integer.valueOf(browserDimensions[1])));
//	        }
//	        catch(NullPointerException e){
//	        }
	}

	public void navigateBack() {
		driver.navigate().back();
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
	}

	public String getTitle() {
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
		return driver.getTitle().trim();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getBrowserAgent() {
		return executeJsAndReturnString("return navigator.userAgent;");
	}

	public String executeJsAndReturnString(String jsScript) {
		return (String) ((JavascriptExecutor) driver).executeScript(jsScript);
	}

	public void acceptAlert() throws IOException {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() throws IOException {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() throws IOException {
		WebDriverWait dWait = new WebDriverWait(driver, webDriverWait);
		String text = null;
		dWait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		return text;
	}

	public void pause(int pauseForSeconds) {
		try {
			Thread.sleep(pauseForSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void openNewTab(String url) {
		// TODO Auto-generated method stub

	}

	public Set<String> getWindowsHandles() {
		return driver.getWindowHandles();
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public void closeWindow() {
		driver.close();

	}

	public void switchToWindow(String window) {
		driver.manage().timeouts().pageLoadTimeout(implicitWait, TimeUnit.SECONDS);
		driver.switchTo().window(window);
	}

	public int getWindowsCount() {
		Set<String> strwindows = driver.getWindowHandles();
		return strwindows.size();
	}

	public void waitForLoad() {

		WebDriverWait dWait = new WebDriverWait(driver, webDriverWait);
		dWait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

	}

	public void switchToModalWindow() {
		driver.switchTo().activeElement();
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

}

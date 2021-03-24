package com.pimco.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.AutomationLibrary.AutomationLibrary;
import com.automation.AutomationLibrary.ui.BrowserLibrary;
import com.automation.AutomationLibrary.ui.ElementLibrary;
import com.automation.AutomationLibrary.ui.PageLibrary;
import com.automation.AutomationLibrary.ui.WebdriverService;
import com.pimco.stepdefinition.Helper;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * @author Genpact Automation Team
 *
 */
public class BaseRunner {

	static AutomationLibrary automationLibrary = null;
	static int count = 0;
	private static Hashtable<Long, AutomationLibrary> automationLibraries = new Hashtable<Long, AutomationLibrary>();
	private static Hashtable<Long, String> roles = new Hashtable<Long, String>();
	private TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

	public static boolean bExecute;
	public static boolean bStatus = true;
	public static int iScriptCount = 0;
	public String osName = System.getProperty("os.name");
	public String scenarioName;

	@Parameters("browser")
	public BaseRunner() {
		loadConfig();
		loadLog4J();
	}

	private void loadConfig() {
		Properties prop = System.getProperties();
		String propFileName = "config.properties";
		try {
			InputStream inputStream = new FileInputStream(propFileName);
			prop.load(inputStream);

		} catch (IOException ex) {
			System.out.println("property file '" + propFileName + "' not found in the classpath");
		}
	}

	private void loadLog4J() {
		// Properties prop = System.getProperties();
		String propFileName = "Log4j.properties";
		try {
			FileInputStream inputStream = new FileInputStream(propFileName);
			PropertyConfigurator.configure(inputStream);
		} catch (IOException ex) {
			System.out.println("property file '" + propFileName + "' not found in the classpath");
		}
	}

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException, Throwable {
		System.out.println("Inside after Method");
		getAutomationLibrary().destroyUILibrary();
	}

	@BeforeMethod
	public void beforeMethod() {
		AutomationLibrary automationLibrary = new AutomationLibrary();
		automationLibrary.initializeUILribray();
		addAutomationLibrary(automationLibrary);
	}

	private void addAutomationLibrary(AutomationLibrary automationLibrary) {
		long threadID = Thread.currentThread().getId();
		automationLibraries.put(new Long(threadID), automationLibrary);

	}

	protected AutomationLibrary getAutomationLibrary() {
		long threadID = Thread.currentThread().getId();
		return automationLibraries.get(new Long(threadID));
	}

	protected WebdriverService getWebDriverService() {
		long threadID = Thread.currentThread().getId();
		return automationLibraries.get(new Long(threadID)).getWebDriverService();
	}

	protected BrowserLibrary getBrowserLibrary() {
		long threadID = Thread.currentThread().getId();
		// AutomationLibrary ID = automationLibraries.get(new Long(threadID));
		return automationLibraries.get(new Long(threadID)).getBrowserLibrary();
	}

	protected PageLibrary getPageLibrary() {
		long threadID = Thread.currentThread().getId();
		return automationLibraries.get(new Long(threadID)).getPageLibrary();
	}

	protected ElementLibrary getElementLibrary() {
		long threadID = Thread.currentThread().getId();
		return automationLibraries.get(new Long(threadID)).getElementLibrary();
	}

	public void setRoleName(String roleName) {
		long threadID = Thread.currentThread().getId();
		roles.put(new Long(threadID), roleName);
	}

	public String getRoleName() {
		long threadID = Thread.currentThread().getId();
		return roles.get(new Long(threadID));
	}

	@AfterClass(alwaysRun = true)

	public void tearDownClass() throws Throwable {

		Helper init = new Helper();
		if (testNGCucumberRunner == null) {
			System.out.println("I am  Null");

			return;
		}

		if (osName.contains("Mac") || osName.contains("mac") || osName.contains("linux") || osName.contains("Linux")) {
			init.sendEmail();
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("pkill -f \"chrome\"");
			pr = rt.exec("pkill -f \"chromedriver\"");

		} else {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec(
					"allure-2.12.1\\bin\\allure.bat generate target\\allure-results --clean -o target\\allure-report");
			pr.waitFor();
			// init.sendEmail();
			pr = rt.exec("taskkill /F /IM chromedriver.exe");
			pr = rt.exec("taskkill /F /IM chrome.exe");
			pr = rt.exec("allure-2.12.1\\bin\\allure.bat serve target\\allure-results");

		}

		testNGCucumberRunner.finish();

	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Throwable {

		this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

		if (osName.contains("Mac") || osName.contains("mac") || osName.contains("linux") || osName.contains("Linux")) {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("pkill -f \"chrome\"");
			pr = rt.exec("pkill -f \"chromedriver\"");
		} else {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("taskkill /F /IM chromedriver.exe");
			pr = rt.exec("taskkill /F /IM chrome.exe");

		}

	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios", retryAnalyzer = com.pimco.retryFailure.RetryAnalyzer.class)
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}

}

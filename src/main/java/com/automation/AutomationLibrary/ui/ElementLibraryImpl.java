package com.automation.AutomationLibrary.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import com.automation.AutomationLibrary.ui.config.UIElement;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.pimco.util.EnvironmentConfig;

//added start
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Date;

//added end
/**
 * @author Genpact Automation Team
 *
 */
public class ElementLibraryImpl implements ElementLibrary {

	private WebdriverService webDriverService;
	private WebDriver webDriver;
	private WebDriverWait wait = null;
	@Value("${webDriverWait}")
	private long webDriverWait;
	@Value("${implicitWait}")
	private int implicitWait;
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/DD/YYYY");

	public ElementLibraryImpl(WebdriverService webDriverService) {
		this.webDriverService = webDriverService;
		this.webDriver = webDriverService.getWebDriver();
		this.wait = new WebDriverWait(this.webDriver, webDriverWait);
	}

	public void click(UIElement uiElement) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		element.click();

	}

	public void click(WebElement element) throws IOException {
		// added by Lakshmi
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clickForcefully(UIElement uiElement) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void doubleClick(UIElement uiElement) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Actions action = new Actions(webDriver);
		action.moveToElement(element).doubleClick().perform();
	}

	public void clickOnSelectedElementInList(UIElement uiElement, int index) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		List<WebElement> elements = webDriverService.findElements(uiElement);
		elements.get(index).click();
	}

	public String getColorOfElement(UIElement uiElement) {
		return webDriverService.findElement(uiElement).getCssValue("color");
	}

	public String getText(WebElement ele) throws IOException {
		String text = ele.getText();
		System.out.println(text);

		return text;
	}

	public String getTextBasedOnIndex(UIElement uiElement, int index) {
		return webDriverService.findElements(uiElement).get(index).getText();
	}

	public String getDisabledText(WebElement ele) {
		// added by Lakshmi
		wait.until(ExpectedConditions.visibilityOf(ele));
		String text = ele.getAttribute("value");
		System.out.println(text);

		return text;
	}

	public void enterText(UIElement uiElement, String text) throws IOException {
		wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		webDriverService.findElement(uiElement).clear();
		webDriverService.findElement(uiElement).sendKeys(text);
	}

	public void enterTextBasedOnIndex(UIElement uiElement, String text, int index) throws IOException {
		webDriverService.findElements(uiElement).get(index).clear();
		webDriverService.findElements(uiElement).get(index).sendKeys(text);
	}

	public void enterText(WebElement ele, String text) throws IOException {
		// added by Lakshmi
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		ele.sendKeys(text);
	}

	public void enterTextWithoutClear(UIElement uiElement, String text) throws IOException {
		wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		webDriverService.findElement(uiElement).sendKeys(text);
		// JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		// executor.executeScript("arguments[0].setAttribute('value', '" + text +"')",
		// uiElement);
	}

	public void clearText(UIElement uiElement) throws IOException {
		wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		webDriverService.findElement(uiElement).clear();
	}

	public void selectDropdownBasedOnText(UIElement uiElement, String text) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		drpDwn.selectByVisibleText(text);
	}

	public void selectDropdownBasedOnValue(UIElement uiElement, String value) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		drpDwn.selectByValue(value);
	}

	public void selectDropdownBasedOnIndex(UIElement uiElement, int index) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		drpDwn.selectByIndex(index);
	}

	public List<String> getDropdownTexts(UIElement uiElement) throws IOException {
		List<String> texts = new ArrayList<String>();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		List<WebElement> drpDwnElems = drpDwn.getOptions();
		for (WebElement drpDwnEle : drpDwnElems)
			texts.add(drpDwnEle.getText());
		return texts;
	}

	public List<String> getSelectedDropdownBasedOnValue(UIElement uiElement) throws IOException {
		List<WebElement> myElems = null;
		List<String> texts = new ArrayList<String>();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		myElems = drpDwn.getAllSelectedOptions();
		for (WebElement elem : myElems)
			texts.add(elem.getAttribute("value"));
		return texts;
	}

	public List<String> getSelectedDropdownBasedOnText(UIElement uiElement) throws IOException {
		List<WebElement> myElems = null;
		List<String> texts = new ArrayList<String>();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		myElems = drpDwn.getAllSelectedOptions();
		for (WebElement elem : myElems)
			texts.add(elem.getText());
		return texts;
	}

	public List<String> getDisabledDropdownValues(UIElement uiElement) throws IOException {
		List<WebElement> myElems = null;
		List<String> texts = new ArrayList<String>();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		Select drpDwn = new Select(webDriverService.findElement(uiElement));
		List<WebElement> drpDwnElems = drpDwn.getOptions();
		for (WebElement drpDwnEle : drpDwnElems) {
			if ((drpDwnEle.getAttribute("disabled") != null) && drpDwnEle.getAttribute("disabled").equals("true")) {
				texts.add(drpDwnEle.getText().trim());
			}
		}
		return texts;
	}

	public String getCssValue(UIElement uiElement, String attribute) {
		return webDriverService.findElement(uiElement).getCssValue(attribute);
	}

	public String getAttribute(UIElement uiElement, String attribute) {

		return webDriverService.findElement(uiElement).getAttribute(attribute);
	}

	public boolean isRadioButtonSelected(UIElement uiElement) {
		return webDriverService.findElement(uiElement).isSelected();
	}

	public int getCount(UIElement uiElement) {
		List<WebElement> xpath = webDriverService.findElements(uiElement);
		return xpath.size();
	}

	public boolean iselementDisplayed(UIElement uiElement) {
		webDriverService.ImplicitWaitSwitchOFF();
		List<WebElement> elements = webDriverService.findElements(uiElement);
		webDriverService.ImplicitWaitSwitchON();
		boolean status = elements.size() > 0 ? true : false;
		return status;
	}

	public boolean isElementDisplayedByIndex(UIElement uiElement, int index) {
		return webDriverService.findElements(uiElement).get(index).isDisplayed();
	}

	public void enterUsingSendkeys(UIElement uiElement) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		element.sendKeys(Keys.ENTER);
	}

	public void deleteUsingSendkeys(UIElement uiElement) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		element.sendKeys(Keys.DELETE);
	}

	public void enterTextUsingSendkeys(UIElement uiElement, String text) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));
		element.sendKeys(text);

	}

	@Override
	public String getText(UIElement ele) throws IOException {
		WebElement we = webDriverService.findElement(ele);
		if (we == null) {
			return null;
		} else {
			return we.getText();
		}
	}

	@Override
	public void waitForElementToDisplay(UIElement uiElement) {
		webDriverService.findElement(uiElement);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clickOnParent(UIElement uiElement) throws IOException {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(webDriverService.getBy(uiElement)));

		WebElement addNewRequestParent = (WebElement) ((JavascriptExecutor) this.webDriver)
				.executeScript("return arguments[0].parentNode;", element);

		addNewRequestParent.click();
	}

	// please cross verify this function
	public void mouseOver(UIElement menuItem, UIElement subMenuItem) throws Exception {
		Actions action = new Actions(webDriver);
		WebElement mainMenu = webDriverService.findElement(menuItem);
		WebElement subMenuItems = webDriverService.findElement(subMenuItem);
		action.moveToElement(mainMenu).moveToElement(subMenuItems).click().build().perform();
	}

	public void mouseOver(UIElement element) throws Exception {
		Actions action = new Actions(webDriver);
		WebElement ele = webDriverService.findElement(element);
		action.moveToElement(ele).click().build().perform();
	}

	public boolean switchToChildWindow(String title) throws IOException {

		String currentWindow = webDriver.getWindowHandle();
		Set<String> availableWindows = webDriver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				if (webDriver.switchTo().window(windowId).getTitle().equals(title)) {
					return true;
				} else {
					// webDriver.switchTo().window(webDriver.WindowHandles.Last());
				}
			}
		}

		return false;
	}

	public boolean switchToMainWindow() throws IOException {

		String currentWindow = webDriver.getWindowHandle();
		String lastWindow = null;
		Set<String> handles = webDriver.getWindowHandles();
		for (String aux : handles) {
			lastWindow = aux;
		}
		webDriver.switchTo().window(lastWindow);
		return true;
	}

	public boolean selectFramePopUp() throws IOException {

		Set<String> handles = webDriver.getWindowHandles();// To handle multiple windows
		String firstWinHandle = webDriver.getWindowHandle(); // To get your main window
		handles.remove(firstWinHandle);
		String winHandle = handles.iterator().next(); // To find popup window
		if (winHandle != firstWinHandle) {
			String secondWinHandle = winHandle;
			webDriver.switchTo().window(secondWinHandle); // To switch to popup window
			return true;
		} else {
			return false;
		}

	}

	// by Index
	public void switchToFrame(int frame) {
		webDriver.switchTo().frame(frame);
	}

	// by name
	public void switchToFrame(String frameName) {
		webDriver.switchTo().frame(frameName);
	}

	// using webelement
	public void switchToFrame(WebElement webelement) throws IOException {

		webDriver.switchTo().frame(webelement);
	}

	// switch from parent to child
	public void switchToFrame(String ParentFrame, String ChildFrame) throws IOException {
		webDriver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
	}

	public void switchtoDefaultFrame() throws IOException {
		webDriver.switchTo().defaultContent();
	}

	public void switchToWindow(String windowName) throws IOException {
		webDriver.switchTo().window(windowName);
	}

	public void holdMoveAndRelease(WebElement fromElement, WebElement toElement) throws IOException {
		Actions action = new Actions(webDriver);
		Action dragdrop = action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build();
		dragdrop.perform();
	}

	public void click_JavaScript(WebElement element) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void refreshBrowser_JavaScript() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("history.go(0)");
	}

	public String getInnerText_JavaScript() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		String sText = executor.executeScript("return document.documentElement.innerText;").toString();
		return sText;
	}

	public String getTitle_JavaScript() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		String sText = executor.executeScript("return document.title;").toString();
		return sText;
	}

	public String scrollPage_JavaScript() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		// Vertical scroll - down by 150 pixels
		String sText = executor.executeScript("window.scrollBy(0,150)").toString();
		;
		return sText;

	}

	public void clear_JavaScript(WebElement element) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].value = '';", element);
	}

	public void enterText_JavaScript(WebElement element, String text) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].value='" + text + "';", element);

	}

	public void setAttribute_JavaScript(WebElement element, String text) throws IOException {

		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].setAttribute('attr', '" + text + "')", element);
	}

	public void moveElement_JavaScript(WebElement element) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		executor.executeScript(mouseOverScript, element);
	}

	public boolean validateText(WebElement element, String expText) throws IOException {
		String actText = getText(element);
		if (actText.equals(expText)) {
			return true;
		}
		return false;
	}

	public boolean validateListBoxValues(UIElement uielement, List<String> expValues) throws IOException {
		List<String> actValues = getDropdownTexts(uielement);
		for (int i = 0; i < expValues.size(); i++) {
			if (actValues.get(i).contains(expValues.get(i))) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public String getLastWorkingDayOfPreviousMonth() {

		LocalDate lastWorkingDayOfMonth = LocalDate.now().withDayOfMonth(1);
		do {
			lastWorkingDayOfMonth = lastWorkingDayOfMonth.minusDays(1);
		} while (lastWorkingDayOfMonth.getDayOfWeek() == DayOfWeek.SATURDAY
				|| lastWorkingDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY);

		return lastWorkingDayOfMonth.toString();

	}

	public int getYear(String strdate) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date startDate = df.parse(strdate);

		LocalDate localDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = localDate.getYear();
		return year;
	}

	public String getPreviousWorkingDay() {

		LocalDate workingDay = LocalDate.now().minusDays(1);
		while (workingDay.getDayOfWeek() == DayOfWeek.SATURDAY || workingDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
			workingDay = workingDay.minusDays(1);
		}
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String output = f.format(workingDay);
		return output;

	}

	public String getLastWorkingDay(String dtDate) {

		LocalDate localDate = LocalDate.parse(dtDate);
		LocalDate workingDay = localDate.minusDays(1);
		while (workingDay.getDayOfWeek() == DayOfWeek.SATURDAY || workingDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
			workingDay = workingDay.minusDays(1);
		}
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String output = f.format(workingDay);
		return output;

	}

	public String getLastWorkingDayOfPreviousYear() {

		LocalDate lastWorkingDayOfMonth = LocalDate.now().minusYears(1);
		while (lastWorkingDayOfMonth.getDayOfWeek() == DayOfWeek.SATURDAY
				|| lastWorkingDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY)
			;
		{
			lastWorkingDayOfMonth = lastWorkingDayOfMonth.minusDays(1);
		}

		return lastWorkingDayOfMonth.toString();

	}

	public void scrollTile_JavaScript(WebElement element) throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public String readExcel(String fileName, String columnName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excelImport\\" + fileName);
		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xls file

		if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name
		String sheetName = EnvironmentConfig.getAPP();
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

		// Find number of rows in excel file

		// int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

		Row row = guru99Sheet.getRow(0);
		short lastColumnUsed = row.getLastCellNum();
		String value = null;
		int column = 0;

		for (int i = 0; i < lastColumnUsed; i++) {

			value = row.getCell(i).getStringCellValue();
			// System.out.println(value);
			if (value.equalsIgnoreCase(columnName)) {
				column = i;
				break;

			}

		}
		row = guru99Sheet.getRow(1);
		Cell cell = row.getCell(column);
		String cellValue = cell.getStringCellValue();

		return cellValue;

	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public String getCellData(String fileName, String element) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excelImport\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}

		String sheetName = EnvironmentConfig.getAPP();
		Sheet st = wb.getSheet(sheetName);
		int rowCount = st.getLastRowNum() - st.getFirstRowNum();
		String cellValue = null;
		String identifier = null;
		for (int i = 1; i < rowCount + 1; i++) {

			Row row = st.getRow(i);
			cellValue = row.getCell(0).getStringCellValue();
			// System.out.print(i+"row"+cellValue+":");
			if (cellValue.equals(element)) {
				identifier = row.getCell(row.getLastCellNum() - 1).getStringCellValue();
				// System.out.print(identifier);
				break;
				// System.out.print(i);
			}
		}

		return identifier;
	}

	public boolean isElementPresent(By by) throws IOException {
		try {
			webDriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public int getRowCountFromExcel(String fileName, String sheetName) throws IOException {

		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\target\\Downloads\\" + fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows()-1;
		return rowCount;

	}

	public void deleteDownloadFile(String fileName) {
		File file = new File(System.getProperty("user.dir") + "\\target\\Downloads\\" + fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	public String getLastExportedExcelFileName(String directoryFilePath) throws Throwable {
		File directory = new File(directoryFilePath);
		File[] files = directory.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;
		String lastExportedExcelFileName = null;
		if (files != null) {
			for (File file : files) {
				
				if (file.lastModified() > lastModifiedTime) {
					chosenFile = file;
					lastModifiedTime = file.lastModified();
				}
			}
		}

		lastExportedExcelFileName = chosenFile.getName();
		return lastExportedExcelFileName;
	}

}

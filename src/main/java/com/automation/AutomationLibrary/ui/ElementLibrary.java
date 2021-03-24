package com.automation.AutomationLibrary.ui;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.automation.AutomationLibrary.ui.config.UIElement;

/**
 * @author Genpact QA Team
 *
 */
public interface ElementLibrary {

	public void click(UIElement uiElement) throws IOException;

	public void click(WebElement element) throws IOException;

	public void clickForcefully(UIElement uiElement) throws IOException;

	public void clickOnParent(UIElement uiElement) throws IOException;

	public void doubleClick(UIElement uiElement) throws IOException;

	public void clickOnSelectedElementInList(UIElement uiElement, int index);

	public String getColorOfElement(UIElement uiElement);

	public String getText(WebElement ele) throws IOException;

	public String getText(UIElement ele) throws IOException;

	public String getTextBasedOnIndex(UIElement uiElement, int index);

	public void enterText(UIElement uiElement, String text) throws IOException;

	public void enterTextBasedOnIndex(UIElement uiElement, String text, int index) throws IOException;

	public void enterText(WebElement ele, String text) throws IOException;

	public void enterTextWithoutClear(UIElement uiElement, String text) throws IOException;

	public void clearText(UIElement uiElement) throws IOException;

	public void selectDropdownBasedOnText(UIElement uiElement, String text) throws IOException;

	public void selectDropdownBasedOnValue(UIElement uiElement, String value) throws IOException;

	public void selectDropdownBasedOnIndex(UIElement uiElement, int index) throws IOException;

	public List<String> getDropdownTexts(UIElement uiElement) throws IOException;

	public List<String> getSelectedDropdownBasedOnValue(UIElement uiElement) throws IOException;

	public List<String> getSelectedDropdownBasedOnText(UIElement uiElement) throws IOException;

	public List<String> getDisabledDropdownValues(UIElement uiElement) throws IOException;

	public String getCssValue(UIElement uiElement, String attribute);

	public String getAttribute(UIElement uiElement, String attribute);

	public boolean isRadioButtonSelected(UIElement uiElement);

	public int getCount(UIElement uiElement);

	public String getDisabledText(WebElement ele);

	public boolean iselementDisplayed(UIElement uiElement);

	public boolean isElementDisplayedByIndex(UIElement uiElement, int index);

	public void waitForElementToDisplay(UIElement uiElement);

	public void enterUsingSendkeys(UIElement uiElement);

	public void deleteUsingSendkeys(UIElement uiElement);

	public void enterTextUsingSendkeys(UIElement uiElement, String text);

	public String getLastWorkingDayOfPreviousMonth();

	public int getYear(String strdate) throws Exception;

	public String getPreviousWorkingDay();

	public String getLastWorkingDay(String dtDate);

	public String getLastWorkingDayOfPreviousYear();

	public void mouseOver(UIElement menuItem, UIElement subMenuItem) throws Exception;

	public void mouseOver(UIElement element) throws Exception;

	public boolean switchToChildWindow(String title) throws Exception;

	public boolean switchToMainWindow() throws Exception;

	public boolean selectFramePopUp() throws Exception;

	public void switchToFrame(int frame) throws Exception;

	public void switchToFrame(String frameName) throws Exception;

	public void switchToFrame(WebElement webelement) throws Exception;

	public void switchToFrame(String ParentFrame, String ChildFrame) throws Exception;

//	public void switchToWindow(int windowId)throws Exception;
	public void switchToWindow(String windowName) throws Exception;

	public void holdMoveAndRelease(WebElement fromElement, WebElement toElement) throws Exception;

	public void click_JavaScript(WebElement element) throws Exception;

	public void refreshBrowser_JavaScript() throws Exception;

	public String getInnerText_JavaScript() throws Exception;

	public String getTitle_JavaScript() throws Exception;

	public String scrollPage_JavaScript() throws Exception;

	public void scrollTile_JavaScript(WebElement element) throws Exception;

	public void clear_JavaScript(WebElement element) throws Exception;

	public void enterText_JavaScript(WebElement element, String text) throws Exception;

	public void setAttribute_JavaScript(WebElement element, String text) throws Exception;

	public void moveElement_JavaScript(WebElement element) throws Exception;

	public boolean validateText(WebElement element, String expText) throws Exception;

	public String readExcel(String fileName, String columnName) throws IOException;

	public boolean isAlertPresent(WebDriver driver);

	public String getCellData(String fileName, String element) throws IOException;

	public boolean isElementPresent(By by) throws IOException;

	public int getRowCountFromExcel(String fileName, String sheetName) throws IOException;

	public void deleteDownloadFile(String fileName);

	public String getLastExportedExcelFileName(String directoryFilePath) throws Throwable;
}

package com.automation.AutomationLibrary.ui;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author Genpact QA team
 *
 */
public interface BrowserLibrary {

	public void navigate(String url);

	public void navigateBack();

	public void refreshBrowser();

	public String getTitle();

	public String getUrl();

	public String getBrowserAgent();

	public String executeJsAndReturnString(String jsScript);

	public void pause(int pauseForSeconds);

	public void acceptAlert() throws IOException;

	public void dismissAlert() throws IOException;

	public String getAlertText() throws IOException;

	public void openNewTab(String url);

	public Set<String> getWindowsHandles();

	public String getCurrentWindowHandle();

	public void closeWindow();

	public void switchToWindow(String window);

	public int getWindowsCount();

	public void waitForLoad();

	public void waitForPageLoaded();

}

package com.pimco.retryFailure;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 0;

	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;

	}

}

package com.pimco.retryFailure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) {
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}

	}

//	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
//	{
//		annotation.setRetryAnalyzer(RetryAnalyzer.class);
//	}	
}

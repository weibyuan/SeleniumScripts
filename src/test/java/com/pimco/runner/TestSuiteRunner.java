package com.pimco.runner;

import cucumber.api.CucumberOptions;
import com.pimco.runner.BaseRunner;

@CucumberOptions(strict = true, monochrome = true, 
	features = {"src/test/resources/features/CRM_UCI.feature" }, 
	tags = {"@TC1"}, 
	glue = {"com.pimco.stepdefinition" }, 
	plugin = { "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty",
						"json:target/cucumber-reports/cucumber.json", })

public class TestSuiteRunner extends BaseRunner {

}

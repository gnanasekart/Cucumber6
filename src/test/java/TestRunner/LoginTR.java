package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/java/Features/Login.feature"},
glue = {"Stepdefinition"},
plugin = {"pretty"},
dryRun = true,
tags = "@smoke")
public class LoginTR {
}

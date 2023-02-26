package com.example.sixservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/tradingtests",
        plugin = {"pretty"},
        glue = "com.example.sixservice"
)
public class CucumberTestTradingRunner  {

}
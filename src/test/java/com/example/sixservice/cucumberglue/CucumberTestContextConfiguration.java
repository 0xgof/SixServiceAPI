package com.example.sixservice.cucumberglue;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.sixservice.SixServiceApplication;

@CucumberContextConfiguration
// @ContextConfiguration(classes = SixServiceApplication.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest(classes = SixServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SixServiceApplication.class, loader = SpringBootContextLoader.class)
public class CucumberTestContextConfiguration {
}

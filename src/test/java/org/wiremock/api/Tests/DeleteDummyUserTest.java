package org.wiremock.api.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wiremock.setup.APIMocks;
import org.wiremock.setup.WiremockSetup;

import io.restassured.RestAssured;

public class DeleteDummyUserTest {
	@BeforeTest
	public void setUp() {
		WiremockSetup.createWireMockServer();
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void postMockUserTest() {
		APIMocks.deleteDummyUser();
		RestAssured.given().log().all()
		.contentType("application/json")		
		.when().log().all().delete("/api/users").then().log().all().statusCode(204);		
	}
	
	
	@AfterTest
	public void tearDown() {
		WiremockSetup.stopWireMockServer();
	}
}

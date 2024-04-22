package org.wiremock.api.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wiremock.setup.APIMocks;
import org.wiremock.setup.WiremockSetup;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class GetUserAPITest {

	@BeforeTest
	public void setUp() {
		WiremockSetup.createWireMockServer();
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void getMockUserTest() {
		APIMocks.getDummyUser();
		RestAssured.given().when().log().all().get("/api/users").then().log().all().statusCode(200).and().body("name",
				equalTo("Tapashi"));
	}
	
	

	@AfterTest
	public void tearDown() {
		WiremockSetup.stopWireMockServer();
	}

}

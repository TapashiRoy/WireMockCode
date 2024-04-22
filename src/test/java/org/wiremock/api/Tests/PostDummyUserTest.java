package org.wiremock.api.Tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wiremock.setup.APIMocks;
import org.wiremock.setup.WiremockSetup;

import io.restassured.RestAssured;

public class PostDummyUserTest {
	@BeforeTest
	public void setUp() {
		WiremockSetup.createWireMockServer();
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void postMockUserTest() {
		APIMocks.postDummyUser();
		RestAssured.given().log().all()
		.contentType("application/json")
		.body("{\"name\":\"Tapashi\"}")
		.when().log().all().post("/api/users").then().log().all().statusCode(201)
		.and().body("message",	equalTo("User is Created"));		
	}
	
	
	@AfterTest
	public void tearDown() {
		WiremockSetup.stopWireMockServer();
	}


}

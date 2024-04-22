package org.wiremock.api.Tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wiremock.setup.APIMocks;
import org.wiremock.setup.WiremockSetup;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserWithQueryParams {
	@BeforeTest
	public void setUp() {
		WiremockSetup.createWireMockServer();
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	
	@Test
	public void getMockUserWithQueryParamsTest() {			
		APIMocks.getWithQueryParams(); // Stub the GET endpoint

        Response response = RestAssured
                .given().log().all()
                .queryParam("param", "value") // Set the query parameter
                .when().log().all()
                .get("/api/users");

        response.then().log().all()
                .statusCode(200)
                .contentType("application/json")
                .body("result", equalTo("Query success!"));
	}
	
	@AfterTest
	public void tearDown() {
		WiremockSetup.stopWireMockServer();
	}


}

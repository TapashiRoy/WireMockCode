package org.wiremock.setup;

import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class APIMocks {

	public static void getDummyUser() {
		// Creating Stubs for GET request
		stubFor(get(urlEqualTo("/api/users")).willReturn(aResponse().withStatus(200)
				.withHeader("content-Type", "application/json").withBody("{\r\n" + "\"name\":\"Tapashi\"\r\n" + "}")));
	}

	public static void getWithQueryParams() {
        stubFor(get(urlPathEqualTo("/api/users"))
        		.withQueryParam("param", equalTo("value"))                
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"result\": \"Query success!\"}")));
        
	}

	public static void postDummyUser() {
		stubFor(post(urlEqualTo("/api/users")).withHeader("content-Type", WireMock.equalTo("application/json"))
				.withRequestBody(equalToJson("{\r\n" + "\"name\":\"Tapashi\"\r\n" + "}"))
				.willReturn(aResponse().withStatus(201).withHeader("content-Type", "application/json")
						.withBody("{\"message\":\"User is Created\"}")));
	}
	
	public static void deleteDummyUser() {
        stubFor(delete(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(204))); // No content response
    }

}

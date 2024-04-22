package org.wiremock.setup;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WiremockSetup {

	private static WireMockServer server;
	
	public static void createWireMockServer() {
		server = new WireMockServer();
		WireMock.configureFor("localhost", 8080);
		server.start();
	}
	
	public static void stopWireMockServer() {		
		server.stop();
	}
}

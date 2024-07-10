package com.bankaya.pokeapiconsumer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;
import java.io.IOException;

import org.junit.runner.RunWith;
import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PokeapiconsumerApplicationTests {
	private MockWebServiceClient mockClient;
	private Resource xsdSchema = new ClassPathResource("pokemon.xsd");
	@Autowired
	private ApplicationContext applicationContext;

	@Before
	public void createClient(){
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void valid_xsd_request_response_test() throws IOException {
		Source requestPayload = new StringSource(
				"<pok:pokemonNameRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
						"<pok:id>15</pok:id>" +
						"</pok:pokemonNameRequest>");

		Source responsePayload = new StringSource(
				"<ns2:pokemonNameResponse xmlns:ns2=\"http://www.bankaya.com/pokeapiconsumer\">" +
						"<ns2:name>beedrill</ns2:name>" +
						"</ns2:pokemonNameResponse>");

		mockClient
				.sendRequest(withPayload(requestPayload))
				.andExpect(noFault())
				.andExpect(payload(responsePayload))
				.andExpect(validPayload(xsdSchema));
	}

	@Test
	public void id_cannot_be_a_name_test() throws IOException {
		Source requestPayload = new StringSource(
				"<ns2:pokemonNameRequest xmlns:ns2='http://www.bankaya.com/pokeapiconsumer'>" +
						"<ns2:id>venosaur</ns2:id>" +
						"</ns2:pokemonNameRequest>");

		mockClient
				.sendRequest(withPayload(requestPayload))
				.andExpect(serverOrReceiverFault());
	}
}

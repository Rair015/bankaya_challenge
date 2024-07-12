package com.bankaya.pokeapiconsumer.cucumber;

import com.bankaya.pokeapiconsumer.PokemonNameResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.ws.test.server.RequestCreators.withPayload;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@WebServiceServerTest
public class MockPokemonClient {
    Source responsePayload;
    Source requestPayload;
    @Autowired
    private MockWebServiceClient mockClient;

    public void storePayload(String xml) {
        requestPayload = new StringSource(xml);
    }

    public void sendPayload() {
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect((request, response) -> responsePayload = response.getPayloadSource());
        System.out.println("reach");
    }
}

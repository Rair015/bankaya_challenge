package com.bankaya.pokeapiconsumer.cucumber;

import com.bankaya.pokeapiconsumer.PokemonNameResponse;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.xml.soap.SOAPElement;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import java.io.*;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@WebServiceServerTest
public class MockPokemonClient {
    PokemonNameResponse pokemonNameResponse;
    @Autowired
    private MockWebServiceClient mockClient;

    public void sendPayload(String xml) throws IOException {
        Map<String, String> NAMESPACE_MAPPING = Map.ofEntries(
                Map.entry("ns2", "http://www.bankaya.com/pokeapiconsumer")
        );

        Source requestPayload = new StringSource(xml);
        ByteArrayOutputStream resultString = new ByteArrayOutputStream();

        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(xpath("//ns2:name", NAMESPACE_MAPPING).evaluatesTo("ditto"));

        System.out.println(resultString);
    }
}

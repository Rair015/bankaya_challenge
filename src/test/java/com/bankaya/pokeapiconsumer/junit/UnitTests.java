package com.bankaya.pokeapiconsumer.junit;

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
import java.util.Map;

import org.junit.runner.RunWith;

import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UnitTests {
    private final Map<String, String> NAMESPACE = Map.ofEntries(
            Map.entry("ns2", "http://www.bankaya.com/pokeapiconsumer")
    );
    private Resource xsdSchema = new ClassPathResource("pokemon.xsd");
    private MockWebServiceClient mockClient;
    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void createClient() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void standaloneUnitTest() throws IOException {
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
                .andExpect((request, response) -> response.writeTo(System.out))
                .andExpect(payload(responsePayload))
                .andExpect(validPayload(xsdSchema));

        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("//ns2:name", NAMESPACE).evaluatesTo("beedrill"));
    }

    @Test
    public void getNameByIdTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonNameRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:id>132</pok:id>" +
                        "</pok:pokemonNameRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("//ns2:name", NAMESPACE).evaluatesTo("ditto"));
    }

    @Test
    public void getIdByNameTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonIdRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:name>bulbasaur</pok:name>" +
                        "</pok:pokemonIdRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("//ns2:id", NAMESPACE).evaluatesTo("1"));
    }

    @Test
    public void getAbilitiesByNameTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonAbilitiesRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:name>bulbasaur</pok:name>" +
                        "</pok:pokemonAbilitiesRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("ns2:isHidden", NAMESPACE).evaluatesTo(false))
                .andExpect(xpath("/ns2:pokemonAbilitiesResponse/ns2:ability[last()]/ns2:slot", NAMESPACE).evaluatesTo(3));
    }

    @Test
    public void getBaseExperienceByNameTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonBaseExperienceRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:name>bulbasaur</pok:name>" +
                        "</pok:pokemonBaseExperienceRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("//ns2:baseExperience", NAMESPACE).evaluatesTo(64));
    }

    @Test
    public void getHeldItemsByNameTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonHeldItemsRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:name>bulbasaur</pok:name>" +
                        "</pok:pokemonHeldItemsRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("/ns2:pokemonHeldItemsResponse//ns2:item", NAMESPACE).evaluatesTo(false));
    }

    @Test
    public void getLocationAreaEncountersByNameTest() {
        Source requestPayload = new StringSource(
                "<pok:pokemonLocationAreaEncountersRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:name>bulbasaur</pok:name>" +
                        "</pok:pokemonLocationAreaEncountersRequest>");
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(xpath("/ns2:pokemonLocationAreaEncountersResponse/ns2:locationArea/ns2:name[1]", NAMESPACE).evaluatesTo("cerulean-city-area"));
    }
}

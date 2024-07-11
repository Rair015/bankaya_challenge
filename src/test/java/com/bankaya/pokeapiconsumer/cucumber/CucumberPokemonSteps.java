package com.bankaya.pokeapiconsumer.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CucumberPokemonSteps {
    @Autowired
    MockPokemonClient mockPokemonClient;

    @When("consumer sends and xml payload with pokemon id {int}")
    public void consumerSendsAndXmlPayloadWithPokemonId(int id) throws IOException {
        String xml = "<pok:pokemonNameRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                        "<pok:id>" + id + "</pok:id>" +
                    "</pok:pokemonNameRequest>";

        mockPokemonClient.sendPayload(xml);
    }

    @Then("consumer receives with pokemon name {string}")
    public void consumerReceivesWithPokemonNameDitto(String name) {
        //String response = cucumberService.getPokemonName();
        //assertEquals(response, name);
    }
}

package com.bankaya.pokeapiconsumer.cucumber;

import com.bankaya.pokeapiconsumer.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CucumberPokemonSteps {
    JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;
    @Autowired
    MockPokemonClient mockPokemonClient;

    @When("consumer sends a xml name request with pokemon id {int}")
    public void consumerSendsAXmlNameRequestWithPokemonId(int id) {
        String xml = "<pok:pokemonNameRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:id>" + id + "</pok:id>" +
                "</pok:pokemonNameRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives pokemon name {string}")
    public void consumerReceivesPokemonNameDitto(String name) throws JAXBException {
        PokemonNameResponse pokemonNameResponse;
        jaxbContext = JAXBContext.newInstance(PokemonNameResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonNameResponse = (PokemonNameResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals(name, pokemonNameResponse.getName());
    }

    @When("consumer sends a xml id request with pokemon name {string}")
    public void consumerSendsAXmlIdRequestWithPokemonNamePikachu(String name) {
        String xml = "<pok:pokemonIdRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:name>" + name + "</pok:name>" +
                "</pok:pokemonIdRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives pokemon id {int}")
    public void consumerReceivesPokemonId(int id) throws JAXBException {
        PokemonIdResponse pokemonIdResponse;
        jaxbContext = JAXBContext.newInstance(PokemonIdResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonIdResponse = (PokemonIdResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals(id, pokemonIdResponse.getId());
    }

    @When("consumer sends a xml locations request with pokemon name {string}")
    public void consumerSendsAXmlLocationsRequestWithPokemonNamePikachu(String name) {
        String xml = "<pok:pokemonLocationAreaEncountersRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:name>" + name + "</pok:name>" +
                "</pok:pokemonLocationAreaEncountersRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives a list of locations for said pokemon")
    public void consumerReceivesAListOfLocationsForSaidPokemon() throws JAXBException {
        PokemonLocationAreaEncountersResponse pokemonLocationAreaEncountersResponse;
        jaxbContext = JAXBContext.newInstance(PokemonLocationAreaEncountersResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonLocationAreaEncountersResponse = (PokemonLocationAreaEncountersResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals(17, pokemonLocationAreaEncountersResponse.getLocationArea().size());
    }

    @When("consumer sends a xml held items request with pokemon name {string}")
    public void consumerSendsAXmlHeldItemsRequestWithPokemonNameDitto(String name) {
        String xml = "<pok:pokemonHeldItemsRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:name>" + name + "</pok:name>" +
                "</pok:pokemonHeldItemsRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives a list of held items for said pokemon")
    public void consumerReceivesAListOfHeldItemsForSaidPokemon() throws JAXBException {
        PokemonHeldItemsResponse pokemonHeldItemsResponse;
        jaxbContext = JAXBContext.newInstance(PokemonHeldItemsResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonHeldItemsResponse = (PokemonHeldItemsResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals("metal-powder", pokemonHeldItemsResponse.getItem().get(0).getItemDetail().getName());
    }

    @When("consumer sends a xml base experience request with pokemon name {string}")
    public void consumerSendsAXmlBaseExperienceRequestWithPokemonNameMew(String name) {
        String xml = "<pok:pokemonBaseExperienceRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:name>" + name + "</pok:name>" +
                "</pok:pokemonBaseExperienceRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives the amount of base experience for said pokemon")
    public void consumerReceivesTheAmountOfBaseExperienceForSaidPokemon() throws JAXBException {
        PokemonBaseExperienceResponse pokemonBaseExperienceResponse;
        jaxbContext = JAXBContext.newInstance(PokemonBaseExperienceResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonBaseExperienceResponse = (PokemonBaseExperienceResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals(300, pokemonBaseExperienceResponse.getBaseExperience());
    }

    @When("consumer sends a xml abilities request with pokemon name {string}")
    public void consumerSendsAXmlAbilitiesRequestWithPokemonNameMew(String name) {
        String xml = "<pok:pokemonAbilitiesRequest xmlns:pok=\"http://www.bankaya.com/pokeapiconsumer\">" +
                "<pok:name>" + name + "</pok:name>" +
                "</pok:pokemonAbilitiesRequest>";

        mockPokemonClient.storePayload(xml);
    }

    @Then("consumer receives the list of abilities for said pokemon")
    public void consumerReceivesTheListOfAbilitiesForSaidPokemon() throws JAXBException {
        PokemonAbilitiesResponse pokemonAbilitiesResponse;
        jaxbContext = JAXBContext.newInstance(PokemonAbilitiesResponse.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        mockPokemonClient.sendPayload();
        pokemonAbilitiesResponse = (PokemonAbilitiesResponse) jaxbUnmarshaller.unmarshal(mockPokemonClient.responsePayload);

        assertEquals(1, pokemonAbilitiesResponse.getAbility().size());
    }
}

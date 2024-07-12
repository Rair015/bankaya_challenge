package com.bankaya.pokeapiconsumer.endpoints;

import com.bankaya.pokeapiconsumer.*;
import com.bankaya.pokeapiconsumer.models.Event;
import com.bankaya.pokeapiconsumer.repositories.EventRepository;
import com.bankaya.pokeapiconsumer.services.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.bankaya.com/pokeapiconsumer";
    private final HttpServletRequest httpServletRequest;
    private final PokemonService pokemonService;
    private final EventRepository eventRepository;

    public PokemonEndpoint(HttpServletRequest httpServletRequest, PokemonService pokemonService, EventRepository eventRepository) {
        this.httpServletRequest = httpServletRequest;
        this.pokemonService = pokemonService;
        this.eventRepository = eventRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonNameRequest")
    @ResponsePayload
    public PokemonNameResponse getPokemonName(@RequestPayload PokemonNameRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonName");

        return pokemonService.getPokemonName(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonIdRequest")
    @ResponsePayload
    public PokemonIdResponse getPokemonId(@RequestPayload PokemonIdRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonId");

        return pokemonService.getPokemonId(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonBaseExperienceRequest")
    @ResponsePayload
    public PokemonBaseExperienceResponse getPokemonBaseExperience(@RequestPayload PokemonBaseExperienceRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonBaseExperience");

        return pokemonService.getPokemonBaseExperience(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonAbilitiesRequest")
    @ResponsePayload
    public PokemonAbilitiesResponse getPokemonAbilities(@RequestPayload PokemonAbilitiesRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonAbilities");

        return pokemonService.getPokemonAbilities(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonHeldItemsRequest")
    @ResponsePayload
    public PokemonHeldItemsResponse getPokemonHeldItems(@RequestPayload PokemonHeldItemsRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonHeldItems");

        return pokemonService.getPokemonHeldItems(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonLocationAreaEncountersRequest")
    @ResponsePayload
    public PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(@RequestPayload PokemonLocationAreaEncountersRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonLocationAreaEncounters");

        return pokemonService.getPokemonLocationAreaEncounters(request.getName());
    }

    private void logEvent(String ipAddress, LocalDateTime dateTime, String methodName) {
        eventRepository.save(new Event(
                ipAddress,
                dateTime,
                methodName
        ));
    }
}

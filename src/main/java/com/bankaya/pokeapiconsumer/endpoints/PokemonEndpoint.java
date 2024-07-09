package com.bankaya.pokeapiconsumer.endpoints;

import com.bankaya.pokeapiconsumer.PokemonAbilitiesRequest;
import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonIdRequest;
import com.bankaya.pokeapiconsumer.models.Event;
import com.bankaya.pokeapiconsumer.repositories.EventRepository;
import com.bankaya.pokeapiconsumer.services.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;
import java.util.List;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.bankaya.com/pokeapiconsumer";

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private EventRepository eventRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonIdRequest")
    @ResponsePayload
    public PokemonIdResponse getPokemonId(@RequestPayload PokemonIdRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonId");

        return pokemonService.getPokemonId(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonAbilitiesRequest")
    @ResponsePayload
    public PokemonAbilitiesResponse getPokemonAbilities(@RequestPayload PokemonAbilitiesRequest request) {
        logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), "getPokemonAbilities");

        return pokemonService.getPokemonAbilities(request.getName());
    }

    private void logEvent(String ipAddr, LocalDateTime dateTime, String methodName) {
        eventRepository.save(new Event(
                ipAddr,
                dateTime,
                methodName
        ));
    }
}

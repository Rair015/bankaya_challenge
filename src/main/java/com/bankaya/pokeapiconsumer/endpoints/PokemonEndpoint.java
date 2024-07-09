package com.bankaya.pokeapiconsumer.endpoints;

import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonByNameRequest;
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

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.bankaya.com/pokeapiconsumer";

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private EventRepository eventRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonByNameRequest")
    @ResponsePayload
    public PokemonIdResponse getPokemonId(@RequestPayload PokemonByNameRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("datetime: " + localDateTime);
        System.out.println("IP: " + httpServletRequest.getRemoteAddr());
        eventRepository.save(new Event(null, httpServletRequest.getRemoteAddr(), localDateTime, "getPokemonId"));

        return pokemonService.getPokemonId(request.getName());
    }
}

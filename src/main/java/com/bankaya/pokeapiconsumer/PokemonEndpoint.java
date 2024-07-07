package com.bankaya.pokeapiconsumer;

import com.bankaya.pokeapiconsumer.model.Event;
import com.bankaya.pokeapiconsumer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.print.attribute.standard.MediaSize;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.bankaya.com/pokeapiconsumer";

    @Autowired
    private PokemonRepository repository;
    @Autowired
    private EventRepository eventRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemonId(@RequestPayload GetPokemonRequest request) {
        eventRepository.save(new Event(null, "564.645.645.65", "2024-07-15", "getPokemonId"));
        GetPokemonResponse response = new GetPokemonResponse();
        Pokemon pokemon = repository.findPokemon(request.getName());
        response.setId(pokemon.getId());

        return response;
    }
}

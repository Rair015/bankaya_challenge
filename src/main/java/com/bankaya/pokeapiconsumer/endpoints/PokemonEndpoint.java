package com.bankaya.pokeapiconsumer.endpoints;

import com.bankaya.pokeapiconsumer.*;
import com.bankaya.pokeapiconsumer.models.Event;
import com.bankaya.pokeapiconsumer.repositories.EventRepository;
import com.bankaya.pokeapiconsumer.services.PokemonService;
import com.bankaya.pokeapiconsumer.utils.PokemonIdToXMLAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.StringWriter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Endpoint
public class PokemonEndpoint {
    Logger logger = Logger.getLogger(getClass().getName());
    private static final String NAMESPACE_URI = "http://www.bankaya.com/pokeapiconsumer";
    private final PokemonIdToXMLAdapter xmlAdapter = new PokemonIdToXMLAdapter();
    private final HttpServletRequest httpServletRequest;
    private final PokemonService pokemonService;
    private final EventRepository eventRepository;

    public PokemonEndpoint(HttpServletRequest httpServletRequest, PokemonService pokemonService, EventRepository eventRepository) throws JAXBException {
        this.httpServletRequest = httpServletRequest;
        this.pokemonService = pokemonService;
        this.eventRepository = eventRepository;
    }

    private void logEvent(String ipAddress, LocalDateTime dateTime, Long duration, String request, String response) {
        String methodName = StackWalker.getInstance()
                .walk(s -> s.skip(1).findFirst())
                .get()
                .getMethodName();

        eventRepository.save(new Event(
                ipAddress,
                dateTime,
                methodName,
                duration,
                request,
                response
        ));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonNameRequest")
    @ResponsePayload
    public PokemonNameResponse getPokemonName(@RequestPayload PokemonNameRequest request) throws Exception {
        Instant start = Instant.now();
        PokemonNameResponse response = null;

        try {
            response = pokemonService.getPokemonName(request.getId());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonIdRequest")
    @ResponsePayload
    public PokemonIdResponse getPokemonId(@RequestPayload PokemonIdRequest request) throws JAXBException {
        Instant start = Instant.now();
        PokemonIdResponse response = null;

        try {
            response = pokemonService.getPokemonId(request.getName());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonBaseExperienceRequest")
    @ResponsePayload
    public PokemonBaseExperienceResponse getPokemonBaseExperience(@RequestPayload PokemonBaseExperienceRequest request) throws JAXBException {
        Instant start = Instant.now();
        PokemonBaseExperienceResponse response = null;

        try {
            response = pokemonService.getPokemonBaseExperience(request.getName());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonAbilitiesRequest")
    @ResponsePayload
    public PokemonAbilitiesResponse getPokemonAbilities(@RequestPayload PokemonAbilitiesRequest request) throws JAXBException {
        Instant start = Instant.now();
        PokemonAbilitiesResponse response = null;

        try {
            response = pokemonService.getPokemonAbilities(request.getName());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonHeldItemsRequest")
    @ResponsePayload
    public PokemonHeldItemsResponse getPokemonHeldItems(@RequestPayload PokemonHeldItemsRequest request) throws JAXBException {
        Instant start = Instant.now();
        PokemonHeldItemsResponse response = null;

        try {
            response = pokemonService.getPokemonHeldItems(request.getName());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonLocationAreaEncountersRequest")
    @ResponsePayload
    public PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(@RequestPayload PokemonLocationAreaEncountersRequest request) throws JAXBException {
        Instant start = Instant.now();
        PokemonLocationAreaEncountersResponse response = null;

        try {
            response = pokemonService.getPokemonLocationAreaEncounters(request.getName());

            return response;
        } finally {
            //logging event
            Instant finish = Instant.now();
            logEvent(
                    httpServletRequest.getRemoteAddr(),
                    LocalDateTime.now(),
                    Duration.between(start, finish).toMillis(),
                    xmlAdapter.marshal(request),
                    xmlAdapter.marshal(response));
        }
    }
}

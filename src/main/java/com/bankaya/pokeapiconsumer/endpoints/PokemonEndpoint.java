package com.bankaya.pokeapiconsumer.endpoints;

import com.bankaya.pokeapiconsumer.*;
import com.bankaya.pokeapiconsumer.models.Event;
import com.bankaya.pokeapiconsumer.repositories.EventRepository;
import com.bankaya.pokeapiconsumer.services.PokemonService;
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
    private StringWriter sw;
    private String xmlRequest;
    private String xmlResponse;
    private Marshaller jaxbMarshaller;
    private JAXBContext contextObj;
    private final HttpServletRequest httpServletRequest;
    private final PokemonService pokemonService;
    private final EventRepository eventRepository;

    public PokemonEndpoint(HttpServletRequest httpServletRequest, PokemonService pokemonService, EventRepository eventRepository) {
        this.httpServletRequest = httpServletRequest;
        this.pokemonService = pokemonService;
        this.eventRepository = eventRepository;
    }

    private void xmlContext() throws JAXBException {
        jaxbMarshaller = contextObj.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
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
    public PokemonNameResponse getPokemonName(@RequestPayload PokemonNameRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonNameResponse response = pokemonService.getPokemonName(request.getId());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonIdRequest")
    @ResponsePayload
    public PokemonIdResponse getPokemonId(@RequestPayload PokemonIdRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonIdResponse response = pokemonService.getPokemonId(request.getName());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonBaseExperienceRequest")
    @ResponsePayload
    public PokemonBaseExperienceResponse getPokemonBaseExperience(@RequestPayload PokemonBaseExperienceRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonBaseExperienceResponse response = pokemonService.getPokemonBaseExperience(request.getName());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonAbilitiesRequest")
    @ResponsePayload
    public PokemonAbilitiesResponse getPokemonAbilities(@RequestPayload PokemonAbilitiesRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonAbilitiesResponse response = pokemonService.getPokemonAbilities(request.getName());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonHeldItemsRequest")
    @ResponsePayload
    public PokemonHeldItemsResponse getPokemonHeldItems(@RequestPayload PokemonHeldItemsRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonHeldItemsResponse response = pokemonService.getPokemonHeldItems(request.getName());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonLocationAreaEncountersRequest")
    @ResponsePayload
    public PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(@RequestPayload PokemonLocationAreaEncountersRequest request) {
        Instant start = Instant.now();

        try {
            //generation of xml with request to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(request.getClass());
            xmlContext();
            jaxbMarshaller.marshal(request, sw);
            xmlRequest = sw.toString();
            xmlRequest = xmlRequest.replace("\n", "");

            PokemonLocationAreaEncountersResponse response = pokemonService.getPokemonLocationAreaEncounters(request.getName());

            //generation of xml with response to log it
            sw = new StringWriter();
            contextObj = JAXBContext.newInstance(response.getClass());
            jaxbMarshaller = contextObj.createMarshaller();
            jaxbMarshaller.marshal(response, sw);
            xmlResponse = sw.toString();

            return response;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            //logging event
            Instant finish = Instant.now();
            long duration = Duration.between(start, finish).toMillis();
            logEvent(httpServletRequest.getRemoteAddr(), LocalDateTime.now(), duration, xmlRequest, xmlResponse);
        }
    }
}

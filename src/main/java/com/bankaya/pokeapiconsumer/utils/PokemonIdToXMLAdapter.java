package com.bankaya.pokeapiconsumer.utils;

import com.bankaya.pokeapiconsumer.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class PokemonIdToXMLAdapter {
    private StringWriter sw;

    private final Marshaller jaxbMarshaller;

    public PokemonIdToXMLAdapter() throws JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance("com.bankaya.pokeapiconsumer");
        jaxbMarshaller = contextObj.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    public String marshal(PokemonNameRequest request) throws Exception {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonNameResponse response) throws Exception {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonIdRequest request) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonIdResponse response) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonBaseExperienceRequest request) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonBaseExperienceResponse response) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonAbilitiesRequest request) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonAbilitiesResponse response) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonHeldItemsRequest request) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonHeldItemsResponse response) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonLocationAreaEncountersRequest request) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(request, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }

    public String marshal(PokemonLocationAreaEncountersResponse response) throws JAXBException {
        sw = new StringWriter();
        jaxbMarshaller.marshal(response, sw);
        String xml = sw.toString();
        return xml.replace(System.lineSeparator(), "");
    }
}

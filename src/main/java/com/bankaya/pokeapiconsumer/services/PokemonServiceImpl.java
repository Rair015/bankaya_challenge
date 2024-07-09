package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonBaseExperienceResponse;
import com.bankaya.pokeapiconsumer.PokemonHeldItemsResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonLocationAreaEncountersResponse;
import com.bankaya.pokeapiconsumer.models.EncounterDTO;
import com.bankaya.pokeapiconsumer.models.LocationAreaDTO;
import com.bankaya.pokeapiconsumer.models.PokemonDTO;
import com.bankaya.pokeapiconsumer.utils.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PokemonIdResponse getPokemonId(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        return PokemonMapper.mapper.dtoToPokemonId(dto);
    }

    @Override
    public PokemonBaseExperienceResponse getPokemonBaseExperience(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        return PokemonMapper.mapper.dtoToPokemonBaseExperience(dto);
    }

    @Override
    public PokemonAbilitiesResponse getPokemonAbilities(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        PokemonAbilitiesResponse response = new PokemonAbilitiesResponse();
        response.getAbility().addAll(PokemonMapper.mapper.dtoToPokemonAbilities(dto.getAbilities()));

        return response;
    }

    @Override
    public PokemonHeldItemsResponse getPokemonHeldItems(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        PokemonHeldItemsResponse response = new PokemonHeldItemsResponse();
        response.getItem().addAll(PokemonMapper.mapper.dtoToPokemonItems(dto.getHeldItems()));

        System.out.println(response);
        return response;
    }

    @Override
    public PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name) {
        EncounterDTO[] dtos = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name + "/encounters", EncounterDTO[].class);
        List<LocationAreaDTO> dtosList = Arrays.stream(dtos).map(EncounterDTO::getLocationArea).collect(Collectors.toList());
        System.out.println("dto: " + dtosList);

        PokemonLocationAreaEncountersResponse response = new PokemonLocationAreaEncountersResponse();
        response.getLocationArea().addAll(PokemonMapper.mapper.dtoToPokemonLocations(dtosList));

        System.out.println("response: " + response);
        return response;
    }
}

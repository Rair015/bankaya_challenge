package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonBaseExperienceResponse;
import com.bankaya.pokeapiconsumer.PokemonHeldItemsResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonLocationAreaEncountersResponse;
import com.bankaya.pokeapiconsumer.PokemonNameResponse;
import com.bankaya.pokeapiconsumer.models.EncounterDTO;
import com.bankaya.pokeapiconsumer.models.LocationAreaDTO;
import com.bankaya.pokeapiconsumer.models.PokemonDTO;
import com.bankaya.pokeapiconsumer.utils.PokemonMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    private static final String POKEAPI = "http://www.bankaya.com/pokeapiconsumer";
    Logger logger = Logger.getLogger(getClass().getName());
    private final RestTemplate restTemplate;

    public PokemonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonNameResponse getPokemonName(Integer id) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + id, PokemonDTO.class);

        return PokemonMapper.mapper.dtoToPokemonName(dto);
    }

    @Override
    public PokemonIdResponse getPokemonId(String name) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + name, PokemonDTO.class);

        return PokemonMapper.mapper.dtoToPokemonId(dto);
    }

    @Override
    public PokemonBaseExperienceResponse getPokemonBaseExperience(String name) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + name, PokemonDTO.class);

        return PokemonMapper.mapper.dtoToPokemonBaseExperience(dto);
    }

    @Override
    public PokemonAbilitiesResponse getPokemonAbilities(String name) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + name, PokemonDTO.class);

        PokemonAbilitiesResponse response = new PokemonAbilitiesResponse();
        response.getAbility().addAll(PokemonMapper.mapper.dtoToPokemonAbilities(dto.getAbilities()));

        return response;
    }

    @Override
    public PokemonHeldItemsResponse getPokemonHeldItems(String name) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + name, PokemonDTO.class);

        PokemonHeldItemsResponse response = new PokemonHeldItemsResponse();
        response.getItem().addAll(PokemonMapper.mapper.dtoToPokemonItems(dto.getHeldItems()));

        return response;
    }

    @Override
    public PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name) {
        EncounterDTO[] dtos = restTemplate.getForObject(POKEAPI + name + "/encounters", EncounterDTO[].class);
        List<LocationAreaDTO> dtosList = Arrays.stream(dtos).map(EncounterDTO::getLocationArea).collect(Collectors.toList());

        PokemonLocationAreaEncountersResponse response = new PokemonLocationAreaEncountersResponse();
        response.getLocationArea().addAll(PokemonMapper.mapper.dtoToPokemonLocations(dtosList));
        return response;
    }
}

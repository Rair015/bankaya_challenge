package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.*;
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
    private static final String POKEAPI = "https://pokeapi.co/api/v2/pokemon/";
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

        List<PokemonAbility> pokemonAbilities = dto.getAbilities().stream().map(abilityDTO -> {
            PokemonAbility ability = new PokemonAbility();
            ability.setAbilityDetail(PokemonMapper.mapper.dtoToPokemonAbilityDetail(abilityDTO.getAbility()));
            ability.setIsHidden(abilityDTO.getIsHidden());
            ability.setSlot(abilityDTO.getSlot());

            return ability;
        }).toList();

        response.getAbility().addAll(pokemonAbilities);

        return response;
    }

    @Override
    public PokemonHeldItemsResponse getPokemonHeldItems(String name) {
        PokemonDTO dto = restTemplate.getForObject(POKEAPI + name, PokemonDTO.class);

        PokemonHeldItemsResponse response = new PokemonHeldItemsResponse();

        List<PokemonItem> pokemonItems = dto.getHeldItems().stream().map(itemDTO -> {
            PokemonItem item = new PokemonItem();
            item.setItemDetail(PokemonMapper.mapper.dtoToPokemonItemDetail(itemDTO.getItem()));

            return item;
        }).toList();

        response.getItem().addAll(pokemonItems);
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

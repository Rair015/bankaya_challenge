package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.*;

public interface PokemonService {
    PokemonNameResponse getPokemonName(Integer id);
    PokemonIdResponse getPokemonId(String name);
    PokemonBaseExperienceResponse getPokemonBaseExperience(String name);
    PokemonAbilitiesResponse getPokemonAbilities(String name);
    PokemonHeldItemsResponse getPokemonHeldItems(String name);
    PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name);
}

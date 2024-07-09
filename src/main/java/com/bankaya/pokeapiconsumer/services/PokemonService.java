package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.*;
import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonBaseExperienceResponse;
import com.bankaya.pokeapiconsumer.PokemonHeldItemsResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonLocationAreaEncountersResponse;

import java.util.List;

public interface PokemonService {
    PokemonIdResponse getPokemonId(String name);
    PokemonBaseExperienceResponse getPokemonBaseExperience(String name);
    PokemonAbilitiesResponse getPokemonAbilities(String name);
    PokemonHeldItemsResponse getPokemonHeldItems(String name);
    PokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(String name);
}

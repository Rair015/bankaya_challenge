package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;

import java.util.List;

public interface PokemonService {
    PokemonIdResponse getPokemonId(String name);
    PokemonAbilitiesResponse getPokemonAbilities(String name);
}

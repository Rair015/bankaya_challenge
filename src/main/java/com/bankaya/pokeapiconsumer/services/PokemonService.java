package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.PokemonIdResponse;

public interface PokemonService {
    PokemonIdResponse getPokemonId(String name);
}

package com.bankaya.pokeapiconsumer.service;

import com.bankaya.pokeapiconsumer.GetPokemonResponse;

public interface PokemonService {
    GetPokemonResponse getPokemonId(String name);
}

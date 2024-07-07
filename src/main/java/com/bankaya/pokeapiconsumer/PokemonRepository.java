package com.bankaya.pokeapiconsumer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PokemonRepository {
    private static final Map<String, Pokemon> pokemonList = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pokemon bulbasaur = new Pokemon();
        bulbasaur.setId(1);
        bulbasaur.setName("bulbasaur");
        pokemonList.put(bulbasaur.getName(), bulbasaur);

        Pokemon charmander = new Pokemon();
        bulbasaur.setId(2);
        bulbasaur.setName("charmander");
        pokemonList.put(charmander.getName(), charmander);

        Pokemon squirtle = new Pokemon();
        bulbasaur.setId(3);
        bulbasaur.setName("squirtle");
        pokemonList.put(squirtle.getName(), squirtle);
    }

    public Pokemon findPokemon(String name) {
        return pokemonList.get(name);
    }
}

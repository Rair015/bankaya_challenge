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
        ObjectFactory factory = new ObjectFactory();

        Pokemon bulbasaur = factory.createPokemon();
        bulbasaur.setId(1);
        bulbasaur.setName("bulbasaur");
        pokemonList.put(bulbasaur.getName(), bulbasaur);

        Pokemon charmander = factory.createPokemon();
        charmander.setId(2);
        charmander.setName("charmander");
        pokemonList.put(charmander.getName(), charmander);

        Pokemon squirtle = factory.createPokemon();
        squirtle.setId(3);
        squirtle.setName("squirtle");
        pokemonList.put(squirtle.getName(), squirtle);

        System.out.println("pokemon initialized: " + pokemonList);
    }

    public Pokemon findPokemon(String name) {
        return pokemonList.get(name);
    }
}

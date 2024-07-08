package com.bankaya.pokeapiconsumer.service;

import com.bankaya.pokeapiconsumer.GetPokemonResponse;
import com.bankaya.pokeapiconsumer.model.PokemonDTO;
import com.bankaya.pokeapiconsumer.util.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public GetPokemonResponse getPokemonId(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        return PokemonMapper.mapper.dtoToResponse(dto);
    }
}

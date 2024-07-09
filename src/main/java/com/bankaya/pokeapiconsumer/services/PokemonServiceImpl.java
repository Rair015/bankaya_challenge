package com.bankaya.pokeapiconsumer.services;

import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.models.PokemonDTO;
import com.bankaya.pokeapiconsumer.utils.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PokemonIdResponse getPokemonId(String name) {
        PokemonDTO dto = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, PokemonDTO.class);
        System.out.println(dto);

        return PokemonMapper.mapper.dtoToResponse(dto);
    }
}

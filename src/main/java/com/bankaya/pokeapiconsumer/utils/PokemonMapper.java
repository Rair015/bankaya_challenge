package com.bankaya.pokeapiconsumer.utils;

import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.models.PokemonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapper {
    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);

    @Mapping(source = "id", target = "id")
    PokemonIdResponse dtoToResponse(PokemonDTO dto);
}

package com.bankaya.pokeapiconsumer.util;

import com.bankaya.pokeapiconsumer.GetPokemonResponse;
import com.bankaya.pokeapiconsumer.model.PokemonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapper {
    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);

    @Mapping(source = "id", target = "id")
    GetPokemonResponse dtoToResponse(PokemonDTO dto);
}

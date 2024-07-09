package com.bankaya.pokeapiconsumer.utils;

import com.bankaya.pokeapiconsumer.PokemonAbilityDetail;
import com.bankaya.pokeapiconsumer.PokemonAbilitiesResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.models.AbilityDetailDTO;
import com.bankaya.pokeapiconsumer.models.PokemonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokemonMapper {
    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);

    PokemonIdResponse dtoToPokemonId(PokemonDTO dto);

    List<PokemonAbilityDetail> dtoToPokemonAbilities(List<AbilityDetailDTO> dto);
}

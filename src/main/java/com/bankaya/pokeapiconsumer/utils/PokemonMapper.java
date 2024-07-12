package com.bankaya.pokeapiconsumer.utils;

import com.bankaya.pokeapiconsumer.*;
import com.bankaya.pokeapiconsumer.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokemonMapper {
    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);
    PokemonNameResponse dtoToPokemonName(PokemonDTO dto);
    PokemonIdResponse dtoToPokemonId(PokemonDTO dto);
    PokemonBaseExperienceResponse dtoToPokemonBaseExperience(PokemonDTO dto);
    PokemonAbility dtoToPokemonAbility(AbilityDTO dto);
    PokemonAbilityDetail dtoToPokemonAbilityDetail(AbilityDetailDTO dto);
    PokemonItem dtoToPokemonItem(ItemDTO dto);
    PokemonItemDetail dtoToPokemonItemDetail(ItemDetailDTO dto);
    List<PokemonLocation> dtoToPokemonLocations(List<LocationAreaDTO> dto);
}

package com.bankaya.pokeapiconsumer.utils;

import com.bankaya.pokeapiconsumer.PokemonAbility;
import com.bankaya.pokeapiconsumer.PokemonLocation;
import com.bankaya.pokeapiconsumer.PokemonBaseExperienceResponse;
import com.bankaya.pokeapiconsumer.PokemonIdResponse;
import com.bankaya.pokeapiconsumer.PokemonItem;
import com.bankaya.pokeapiconsumer.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokemonMapper {
    PokemonMapper mapper = Mappers.getMapper(PokemonMapper.class);
    PokemonIdResponse dtoToPokemonId(PokemonDTO dto);
    PokemonBaseExperienceResponse dtoToPokemonBaseExperience(PokemonDTO dto);
    List<PokemonAbility> dtoToPokemonAbilities(List<AbilityDTO> dto);
    List<PokemonItem> dtoToPokemonItems(List<ItemDTO> dto);
    List<PokemonLocation> dtoToPokemonLocations(List<LocationAreaDTO> dto);
}

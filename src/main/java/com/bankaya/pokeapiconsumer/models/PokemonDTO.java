package com.bankaya.pokeapiconsumer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDTO {
    private Integer id;
    private String name;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    private List<AbilityDTO> abilities;
    @JsonProperty("held_items")
    private List<ItemDTO> heldItems;
}

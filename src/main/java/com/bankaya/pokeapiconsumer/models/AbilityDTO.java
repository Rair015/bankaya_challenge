package com.bankaya.pokeapiconsumer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDTO {
    @JsonProperty("is_hidden")
    private Boolean isHidden;
    private Integer slot;
    private AbilityDetailDTO ability;
}

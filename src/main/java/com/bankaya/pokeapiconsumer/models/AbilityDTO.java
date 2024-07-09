package com.bankaya.pokeapiconsumer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDTO {
    private Boolean isHidden;
    private Integer slot;
    private AbilityDetailDTO ability;
}

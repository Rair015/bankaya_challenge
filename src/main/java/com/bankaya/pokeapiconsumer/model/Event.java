package com.bankaya.pokeapiconsumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer id;

    private String ipOrigin;

    @Temporal(TemporalType.TIMESTAMP)
    private String loggedOn;

    private String methodName;
}

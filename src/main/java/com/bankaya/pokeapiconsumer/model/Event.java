package com.bankaya.pokeapiconsumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer id;

    private String ipOrigin;

    private LocalDateTime loggedOn;

    private String methodName;
}

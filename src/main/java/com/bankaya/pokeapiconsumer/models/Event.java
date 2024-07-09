package com.bankaya.pokeapiconsumer.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer id;

    private String ipOrigin;

    private LocalDateTime loggedOn;

    private String methodName;

    public Event(String ipOrigin, LocalDateTime loggedOn, String methodName) {
        this.ipOrigin = ipOrigin;
        this.loggedOn = loggedOn;
        this.methodName = methodName;
    }
}

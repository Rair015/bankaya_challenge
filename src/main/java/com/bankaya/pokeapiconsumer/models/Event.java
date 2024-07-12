package com.bankaya.pokeapiconsumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    private Long duration;
    @Lob
    private String request;
    @Lob
    private String response;

    public Event(String ipOrigin, LocalDateTime loggedOn, String methodName, Long duration, String request, String response) {
        this.ipOrigin = ipOrigin;
        this.loggedOn = loggedOn;
        this.methodName = methodName;
        this.duration = duration;
        this.request = request;
        this.response = response;
    }
}

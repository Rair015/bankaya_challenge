package com.bankaya.pokeapiconsumer.repository;

import com.bankaya.pokeapiconsumer.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}

package com.bankaya.pokeapiconsumer.repositories;

import com.bankaya.pokeapiconsumer.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {}

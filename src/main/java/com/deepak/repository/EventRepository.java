package com.deepak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.entity.Event;
import com.deepak.entity.Organizer;
import com.deepak.entity.Venue;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByVenue(Venue venue);
    List<Event> findByOrganizer(Organizer organizer);
}


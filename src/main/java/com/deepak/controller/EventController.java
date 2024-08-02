package com.deepak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.entity.Event;
import com.deepak.entity.Organizer;
import com.deepak.entity.Venue;
import com.deepak.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event existingEvent = eventService.getEventById(id);
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setDescription(event.getDescription());
        return eventService.updateEvent(existingEvent);
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/venue/{venueId}")
    public List<Event> getEventsByVenue(@PathVariable Long venueId) {
        Venue venue = new Venue();
    
        venue.setId(venueId);
        return eventService.getEventsByVenue(venue);
    }

    @GetMapping("/organizer/{organizerId}")
    public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);
        return eventService.getEventsByOrganizer(organizer);
    }
    
}


package com.deepak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.entity.Event;
import com.deepak.entity.Organizer;
import com.deepak.entity.Venue;
import com.deepak.repository.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

	public List<Event> getEventsByVenue(Venue venue) {
		// TODO Auto-generated method stub
		return eventRepository.findByVenue(venue);

	}

	public List<Event> getEventsByOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub
		 return eventRepository.findByOrganizer(organizer);

	}

	
}



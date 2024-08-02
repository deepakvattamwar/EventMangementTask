package com.deepak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.entity.Organizer;
import com.deepak.repository.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public  List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElseThrow();
    }

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer updateOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}





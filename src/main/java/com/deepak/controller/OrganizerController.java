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
import org.springframework.web.bind.annotation.RestController;

import com.deepak.entity.Organizer;
import com.deepak.service.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerService.getAllOrganizers();
    }

    @GetMapping("/{id}")
    public Organizer getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id);
    }

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.createOrganizer(organizer);
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        Organizer existingOrganizer = organizerService.getOrganizerById(id);
        existingOrganizer.setName(organizer.getName());
        existingOrganizer.setContactInfo(organizer.getContactInfo());
        return organizerService.updateOrganizer(existingOrganizer);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
    }
}


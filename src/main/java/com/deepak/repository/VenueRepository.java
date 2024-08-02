package com.deepak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}


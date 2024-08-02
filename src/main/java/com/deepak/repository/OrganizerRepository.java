package com.deepak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.entity.Organizer;
import com.deepak.entity.Venue;
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

	void deleteById(Long id);

	Optional<Organizer> findById(Long id);
}

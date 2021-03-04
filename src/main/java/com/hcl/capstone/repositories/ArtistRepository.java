package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.capstone.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

	public List<Artist> findByOrderByName();
	
}

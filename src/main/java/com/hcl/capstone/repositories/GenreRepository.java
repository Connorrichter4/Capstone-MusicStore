package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	public List<Genre> findByOrderByName();
}

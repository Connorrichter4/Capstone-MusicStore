package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.capstone.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	public List<Genre> findByNameContains(String name);
	public List<Genre> findByAlbumNameContains(String name);
	public List<Genre> findByAlbumSongNameContains(String name);
}

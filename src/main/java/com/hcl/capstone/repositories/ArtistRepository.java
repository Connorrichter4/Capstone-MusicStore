package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Song;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

	public List<Artist> findByOrderByName();
	
	public List<Artist> findByNameContains(String name);
	

	public List<Artist> findByAlbumNameContains(String name);
	
	public List<Artist> findBySongsNameContains(String name);
	
	
}

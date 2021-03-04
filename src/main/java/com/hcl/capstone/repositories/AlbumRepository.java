package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entities.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

	public List<Album> findByOrderByName();
	
	@Query("SELECT album FROM Album album WHERE album.artist.name = :artistName")
	public List<Album> findByArtistName(@Param("artistName") String artistName);
}

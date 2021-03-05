package com.hcl.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.capstone.entities.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	public List<Song> findByName(String name);
	
	public List<Song> findByOrderByName();
	
	
	@Query("SELECT song FROM Song song WHERE song.price BETWEEN :minPrice and :maxPrice")
	public List<Song> findByPriceRange(@Param("minPrice") Double minPrice,@Param("maxPrice") Double maxPrice);
	
	@Query("SELECT song FROM Song song WHERE song.album.name = :albumName")
	public List<Song> findByAlbumName(@Param("albumName") String albumName);
	
	
	@Query("SELECT song FROM Song song WHERE song.artist.name = :artistName")
	public List<Song> findByArtistName(@Param("artistName") String artistName);
	
	public List<Song> findByNameContains(String name);
	public List<Song> findByArtistNameContains(String name);
	public List<Song> findByAlbumNameContains(String name);


}

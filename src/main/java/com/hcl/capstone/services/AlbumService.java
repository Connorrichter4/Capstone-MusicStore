package com.hcl.capstone.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.repositories.AlbumRepository;

@Service
public class AlbumService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AlbumRepository repo;

	@Autowired
	SongService songService;
	
	/*
	 * 
	 * 
	 * 			Finding Albums   
	 * 
	 * 
	 */

	public List<Album> findAllAlbums() {
		List<Album> albums = new ArrayList<Album>();
		for (Album album : repo.findAll()) {
			logger.info("found an album...");
			albums.add(album);
		}
		return albums;
	}

	public List<Album> sortAlbumsBySortedName() {
		return repo.findByOrderByName();
	}

	public List<Album> getAlbumByArtistName(String artist) {
		return repo.findByArtistName(artist);
	}

	public Optional<Album> getAlbumById(Long id) {
		return repo.findById(id);
	}
	
	/*
	 * 
	 * 
	 * 			CRUD Albums   
	 * 
	 * 
	 */

	public Album createAlbum(Album album) {
		return repo.save(album);
	}

	public Boolean updateAlbum(Long id, Album album) {
		Album oldAlbum = getAlbumById(id).get();
		if (oldAlbum == null) {
			// throw new SongNotFoundException(id);
			return false;
		} else {

			oldAlbum.setName(album.getName());
			oldAlbum.setPrice(album.getPrice());
			oldAlbum.setInventory(album.getInventory());
			oldAlbum.setDate(album.getDate());
			oldAlbum.setImage(album.getImage());
			oldAlbum.setArtist(album.getArtist());
			repo.save(oldAlbum);

			return true;
		}
	}

	public Boolean deleteAlbum(Long id) {
		Optional<Album> album = getAlbumById(id);
		logger.info("inside delete album");
		if (!album.isPresent()) {
			logger.info("album is not present ************************************");
			// throw new SongNotFoundException(id);
			return false;
		} else {

			// find and delete all songs
			Iterable<Song> songs = songService.getSongByAlbumName(album.get().getName());

			for (Song song : songs) {
				logger.info(song.getName());
				songService.deleteSong(song.getId());
			}

			repo.delete(album.get());
			return true;
		}

	}
	
	/*
	 * 
	 * 
	 * 		SEARCH QUERIES
	 * 
	 * 
	 */
	
	public List<Album> search(String search, String criteria){
		List<Album> albums = new ArrayList<Album>();
		logger.info("======================>>> album service: "+criteria);
		try {
			switch(criteria) {
			case "name":
			case "album":
				for (Album album : repo.findByNameContains(search)) {
					logger.info("======================>>> found an album by "+criteria);
					albums.add(album);
				}				
				break;
			case "artist":
				logger.info("======================>>> inside "+criteria+" case");
				for (Album album : repo.findByArtistNameContains(search)) {
					logger.info("======================>>> found an album by "+criteria);
					albums.add(album);
				}	
				break;
			case "genre":
				for (Album album : repo.findByGenreNameContains(search)) {
					logger.info("======================>>> found an album by "+criteria);
					albums.add(album);
				}	
				break;
			case "status":
				for (Album album : repo.findByStatusContains(search)) {
					logger.info("======================>>> found an album by "+criteria);
					albums.add(album);
				}	
				break;
			case "song":
				for (Album album : repo.findBySongNameContains(search)) {
					logger.info("======================>>> found an album by "+criteria);
					albums.add(album);
				}	
				break;
			}
			if(albums.isEmpty()) {
				logger.info("======================>>> DID NOT FIND an album by "+criteria);
				return (List<Album>) repo.findAll();
			}
			return albums;
		}catch(Exception ex) {
			return (List<Album>) repo.findAll();
		}
	}
	

}

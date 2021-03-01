package com.hcl.capstone.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	Song song = new Song();
	
	public Iterable<Song> getAllSong(){
		return songRepository.findAll();
	}
	
	public Optional<Song> getSongById(Long id){
		return songRepository.findById(id);
	}
	
	public Song createSong(String name, BigDecimal price, Long inventory, Artist artist, Album album, Genre genre) {
		song.setName(name);
		song.setPrice(price);
		song.setInventory(inventory);
		song.setArtist(artist);
		song.setAlbum(album);
		return song;
	}
	
	public Boolean updateSong(Long id, String name, BigDecimal price, Long inventory, Artist artist, Album album, Genre genre) {
		Optional<Song> foundSong = getSongById(id);
		if(foundSong.isPresent()) {
			//throw new SongNotFoundException(id);
			return false;
		}else {
			Song updateSong = foundSong.get();
			updateSong.setName(name);
			updateSong.setPrice(price);
			updateSong.setInventory(inventory);
			updateSong.setArtist(artist);
			updateSong.setAlbum(album);
			return true;
		}
	}
	
	public Boolean deleteSong(Long id) {
		if(getSongById(id).get() != null) {
			//throw new SongNotFoundException(id);
			return false;
		}else {
			songRepository.delete(getSongById(id).get());
			return true;
		}
		
	}

	
}

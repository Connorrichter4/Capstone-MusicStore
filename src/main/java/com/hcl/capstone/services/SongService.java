package com.hcl.capstone.services;

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
	private Song song = new Song();
	
	public Iterable<Song> getAllSong(){
		return songRepository.findAll();
	}
	
	public Optional<Song> getSongById(Long id){
		return songRepository.findById(id);
	}
	
	public Song createSong(String name, Double price, Long inventory, Artist artist, Album album) {
		song.setName(name);
		song.setPrice(price);
		song.setInventory(inventory);
		song.setAlbum(album);
		song.setAlbum(album);
		return songRepository.save(song);
	}
	
	public Boolean updateSong(Long id, String name, Double price, Long inventory, Artist artist, Album album) {
		Optional<Song> foundSong = getSongById(id);
		if(foundSong.isEmpty()) {
			//throw new SongNotFoundException(id);
			return false;
		}else {
			Song updateSong = foundSong.get();
			updateSong.setName(name);
			updateSong.setPrice(price);
			updateSong.setInventory(inventory);
			updateSong.setArtist(artist);
			updateSong.setAlbum(album);
			songRepository.save(updateSong);
			return true;
		}
	}
	
	public Boolean deleteSong(Long id) {
		if(getSongById(id) .isEmpty()) {
			//throw new SongNotFoundException(id);
			return false;
		}else {
			songRepository.delete(getSongById(id).get());
			return true;
		}
		
	}

	
}

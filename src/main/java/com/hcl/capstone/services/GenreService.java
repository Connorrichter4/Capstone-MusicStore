package com.hcl.capstone.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;

import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.repositories.AlbumRepository;
import com.hcl.capstone.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepo;

	@Autowired
	AlbumRepository albumRepo;
	
	@Autowired 
	AlbumService albumService;

	public Iterable<Genre> getAllGenre() {
		return genreRepo.findAll();
	}
	
	public List<Genre> sortSongsBySortedName(){
		return genreRepo.findByOrderByName();
	}

	public Optional<Genre> getGenreById(Long id) {
		return genreRepo.findById(id);
	}

	public Boolean updateGenre(Long id, String name, String desctiption) {
		Optional<Genre> foundGenre = genreRepo.findById(id);
		if (!foundGenre.isPresent()) {
			
			return false;
		} else {
			
			Genre existGenre = foundGenre.get();
			
			existGenre.setName(name);
			existGenre.setDescription(desctiption);
			
			genreRepo.save(existGenre);
			
			
			return true;

		}

	}

	public Boolean deleteGenre(Long id) {
		Optional<Genre> foundGenre = genreRepo.findById(id);
		if (!foundGenre.isPresent()) {
			return false;
		} else {
			List<Album> foundAlbums = albumService.finByGenreId(id);
			for(Album album : foundAlbums) {
				album.setGenre(null);
			}
			
			genreRepo.deleteById(id);
			return true;
		}

	}

	public Genre createGenre(String name, String description) {

		Genre newGenre = new Genre();
		newGenre.setName(name);
		newGenre.setDescription(description);
		Genre createdGenre = genreRepo.save(newGenre);

		return createdGenre;
	}

}

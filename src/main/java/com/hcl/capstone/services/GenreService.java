package com.hcl.capstone.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;

import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.repositories.AlbumRepository;
import com.hcl.capstone.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepo;

	@Autowired
	AlbumRepository albumRepo;

	public Iterable<Genre> getAllGenre() {
		return genreRepo.findAll();
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

			genreRepo.deleteById(id);

			return true;
		}

	}

	public Genre createGenre(String name, String description, Long albumid) {

		Album albumFromDb = albumRepo.findById(albumid).get();
		albumFromDb.toString();

		List<Album> album = new ArrayList<Album>();
		album.add(albumFromDb);

		Genre newGenre = new Genre();
		newGenre.setName(name);
		newGenre.setDescription(description);
		newGenre.setAlbum(album);
		Genre createdGenre = genreRepo.save(newGenre);

		createdGenre.toString();

		return genreRepo.save(newGenre);
	}

}

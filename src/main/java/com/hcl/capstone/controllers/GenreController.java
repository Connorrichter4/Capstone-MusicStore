package com.hcl.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.capstone.entities.Album;

import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.services.AlbumService;

import com.hcl.capstone.services.GenreService;

@Controller
public class GenreController {

	@Autowired
	GenreService genreService;

	@Autowired
	AlbumService albumService;

	// CREATE Genre ***********************************************
	@GetMapping("/createGenre")
	public String createGenre(Model model) {


		Genre newGenre = new Genre();
		model.addAttribute("genre", newGenre);

		List<Album> allalbums = albumService.findAllAlbums();

		model.addAttribute("allalbums", allalbums);

		return "createGenre";
	}

	@PostMapping("/newGenre")
	public String newGenre(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("album") Long albumid, Model model) {

		genreService.createGenre(name, description, albumid);

		return "redirect:/allGenres";
	}
	
//	 Display All Genre **********************************
	@GetMapping("/allGenres")
	public String allGenres(Model model) {

		Iterable<Genre> genres = genreService.getAllGenre();
		model.addAttribute("genres", genres);

		return "displayAllGenres";
	}


	// Delete Genre *************************************************
	@GetMapping("/deletegenre")
	public String deletegenre(@RequestParam("Id") long Id, Model model) {

		genreService.deleteGenre(Id);

		return "redirect:/allGenres";
	}


	// Map to Update Genre ***************************************************
	@GetMapping("/updategenre")
	public String updategenre(@RequestParam("Id") long Id, Model themodel) {

		Optional<Genre> genreFromDb = genreService.getGenreById(Id);

		themodel.addAttribute("genre", genreFromDb);

		return "updateGenre";

	}

	// Update Genre ***************************************************
	@PostMapping("/updateGenreinfo")
	public String updateGenreinfo(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {

		genreService.updateGenre(id, name, description);

		return "redirect:/allGenres";
	}

}

package com.hcl.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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
	@GetMapping("/admin/createGenre")
	public String createGenre(Model model) {


		Genre newGenre = new Genre();
		model.addAttribute("genre", newGenre);

		return "createGenre";
	}

	@PostMapping("/admin/newGenre")
	public RedirectView newGenre(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {

		genreService.createGenre(name, description);

		return new RedirectView("/admin/");
	}
	
//	 Display All Genre **********************************
	@GetMapping("/allGenres")
	public String allGenres(Model model) {

		Iterable<Genre> genres = genreService.getAllGenre();
		model.addAttribute("genres", genres);

		return "displayAllGenres";
	}


	// Delete Genre *************************************************
	@GetMapping("/admin/deletegenre/{id}")
	public RedirectView deletegenre(@PathVariable long id, Model model) {

		if (genreService.deleteGenre(id)) {
			return new RedirectView("/admin/");
		}

		//return "redirect:/admin";
		return new RedirectView("/admin/");
	}


	// Map to Update Genre ***************************************************
	@GetMapping("/admin/updategenre/{id}")
	public String updategenre(@PathVariable long id, Model themodel) {

		Optional<Genre> genreFromDb = genreService.getGenreById(id);

		themodel.addAttribute("genre", genreFromDb);

		return "updateGenre";

	}

	// Update Genre ***************************************************
	@PostMapping("/admin/updateGenreinfo")
	public RedirectView updateGenreinfo(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {

		genreService.updateGenre(id, name, description);

		return new RedirectView("/admin/");
	}

}

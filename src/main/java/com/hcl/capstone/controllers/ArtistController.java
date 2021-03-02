
package com.hcl.capstone.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.services.ArtistService;


@Controller
public class ArtistController {

	@Autowired
	ArtistService artistService;

	// CREATE ***********************************************
	@GetMapping("/createArtist")
	public String createArtist(Model model) {

		Artist newArtist = new Artist();
		model.addAttribute("artist", newArtist);

		return "createArtist";
	}

	@PostMapping("/newArtist")
	public String newArtist(Artist artist, Model model) {

		artistService.save(artist);
		return "redirect:/allArtists";
	}

	// Display All Artists **********************************
	@GetMapping("/allArtists")
	public String allArtists(Model model) {

		Iterable<Artist> artists = artistService.getAllArtist();
		model.addAttribute("artists", artists);

		return "displayAll";
	}

	// Delete *************************************************
	@GetMapping("/deleteartist")
	public String deleteartist(@RequestParam("Id") long Id, Model model) {

		artistService.deleteArtist(Id);

		return "redirect:/allArtists";
	}

	// Update ***************************************************
	@GetMapping("/updateartist")
	public String updateartist(@RequestParam("Id") long Id, Model themodel) {

		Optional<Artist> artistFromDb = artistService.getArtistById(Id);

		themodel.addAttribute("artist", artistFromDb);

		return "createArtist";

	}

}


package com.hcl.capstone.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.SongService;


@Controller
public class ArtistController {

	@Autowired
	ArtistService artistService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	SongService songService;

	// CREATE ***********************************************
	@GetMapping("/admin/createArtist")
	public String createArtist(Model model) {

		Artist newArtist = new Artist();
		model.addAttribute("artist", newArtist);

		return "createArtist";
	}

	@PostMapping("/admin/newArtist")
	public String newArtist(Artist artist, Model model) {

		artistService.save(artist);
		return "redirect:/admin/";
	}

	// Display All Artists **********************************
	@GetMapping("/allArtists")
	public String allArtists(Model model) {

		Iterable<Artist> artists = artistService.getAllArtist();
		model.addAttribute("artists", artists);

		return "displayAll";
	}

	// Delete *************************************************
	@GetMapping("/admin/deleteartist/{id}")
	public RedirectView deleteartist(@PathVariable Long id) {

		artistService.deleteArtist(id);
		
		return new RedirectView("/admin/");
	}


	// Update ***************************************************
	@GetMapping("/admin/updateartist/{id}")
	public String updateartist(@PathVariable Long id, Model themodel) {

		Optional<Artist> artistFromDb = artistService.getArtistById(id);

		themodel.addAttribute("artist", artistFromDb);

		return "createArtist";

	}

}

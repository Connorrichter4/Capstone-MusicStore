package com.hcl.capstone.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
//import com.hcl.capstone.entities.User;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.GenreService;
import com.hcl.capstone.services.SongService;
import com.hcl.capstone.services.UserService;

@Controller
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SongService songService;

	@Autowired
	UserService userService;

	@Autowired
	AlbumService albumService;

	@Autowired
	ArtistService artistService;
	
	@Autowired
	GenreService genreService;


	@GetMapping("/admin/")
	public String showProducts(ModelMap model) {

		logger.info("inside show admin home");
		Iterable<Album> albums = albumService.sortAlbumsBySortedName();
		Iterable<Artist> artists = artistService.sortArtistsBySortedName();
		Iterable<Song> songs = songService.sortSongsBySortedName();
		Iterable<Genre> genres = genreService.sortSongsBySortedName();
		model.addAttribute("albums", albums);
		model.addAttribute("artists", artists);
		model.addAttribute("songs", songs);
		model.addAttribute("genres", genres);
	
		
		return "admin-products";
	}
	
	@GetMapping("/403")
	public String restrictedPage(ModelMap model) {
		return "restricted";
	}

}

package com.hcl.capstone.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.SongService;




@Controller
public class AlbumController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AlbumService albumService;
	@Autowired
	ArtistService artistService;
	@Autowired
	SongService songService;
	
	@Autowired
	ArtistService artistService;
	
	@GetMapping("/album")
	public String getAllAlbums(ModelMap map) {
		logger.info("inside get mapping");
		List<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		Iterable<Song> songs = songService.getAllSong();
//		Iterable<Song> genres = songService.getAllGenres(); //TODO: ADD GENRE SERVICE LATER
		map.put("albums", albums);
		map.put("songs", songs);
		map.put("artists", artists);
		map.put("genres", "Under Construction...");	//TODO: add genre service later
		return "test_album";
	}
	
	@GetMapping("/album/{id}")
	public String getAlbum(ModelMap map, @PathVariable Long id) {
		Album album = service.getAlbumById(id).get();
		logger.info(album.toString());
		map.put("album", album);
		return "test_this_album";
	}
	
	/*
	 * 
	 * 
	 * 			CRUD Album
	 * 
	 * 
	 */
	
	@GetMapping("/admin/album/create")
	public String createAlbumForm(ModelMap model) {

//		Iterable<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
//		model.put("albums", albums);
		model.put("artists", artists);
		
		return "admin-create-album";
	}
	
	@PostMapping("/admin/album/create")
	public RedirectView createAlbumProduct(ModelMap model, Album album, @RequestParam Long artist_id) {
		
		album.setArtist(artistService.getArtistById(artist_id).get());

		logger.info(album.toString());

		service.createAlbum(album);
		return new RedirectView("/admin/");

	}
	
	@GetMapping("/admin/album/{id}")
	public String getAlbumProduct(ModelMap model, @PathVariable Long id) {
		
		Album album = service.getAlbumById(id).get();
		logger.info(album.toString());
		
		Iterable<Artist> artists = artistService.getAllArtist();
		
		
		model.put("artists", artists);
		model.put("album", album);
		
		return "admin-edit-album";
	}

	@PostMapping("/admin/album/{id}")
	public ModelAndView updateAlbumProduct(ModelMap model, @PathVariable Long id, Album album,
			@RequestParam Long artist_id) {
		
		
		album.setArtist(artistService.getArtistById(artist_id).get());
	

		logger.info(album.toString());
		if (service.updateAlbum(id, album)) {
			return new ModelAndView("redirect:/admin/");
		}
		model.put("error", "There was an error updating the album");
		return new ModelAndView("redirect:/admin/album/" + id, model);
	}
	
	@GetMapping("/admin/album/delete/{id}")
	public RedirectView deleteAlbumProduct(@PathVariable Long id) {
		logger.info("inside delete function");
		
		// need to add model for delete success and failure
		
		if (service.deleteAlbum(id)) {
			return new RedirectView("/admin/");
		}
		return new RedirectView("/admin/");
	}

}

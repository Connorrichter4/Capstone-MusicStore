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

import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.GenreService;


import com.hcl.capstone.entities.Song;


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
	GenreService genreService;
	

	


	
	@GetMapping({"/","/index","/home"})
	public String getAllAlbums(ModelMap map) {
		logger.info("inside get mapping");
		List<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		Iterable<Song> songs = songService.getAllSong();
		Iterable<Genre> genres = genreService.getAllGenre(); //TODO: ADD GENRE SERVICE LATER
		map.put("albums", albums);
		map.put("songs", songs);
		map.put("artists", artists);
		map.put("genres", genres);	//TODO: add genre service later
		return "test_home";
	}
	
	@GetMapping("/album/{id}")
	public String getAlbum(ModelMap map, @PathVariable Long id) {
		Album album = albumService.getAlbumById(id).get();

		Artist artist = artistService.getArtistById(album.getArtist().getId()).get();
		Genre genre = genreService.getGenreById(album.getGenre().getId()).get();
		map.put("album", album);
		map.put("artist", artist);
		map.put("genre", genre);
		return "test_album";
	}
	
	@GetMapping("/song/{id}")
	public String getSong(ModelMap map, @PathVariable Long id) {
		Song song = songService.getSongById(id).get();
		Album album = albumService.getAlbumById(song.getAlbum().getId()).get();
		Artist artist = artistService.getArtistById(song.getArtist().getId()).get();
		Genre genre = genreService.getGenreById(song.getAlbum().getGenre().getId()).get();
		map.put("song", song);

		map.put("album", album);
		map.put("artist", artist);
		map.put("genre", genre);
		return "test_song";
	}
	
	@GetMapping("/artist/{id}")
	public String getArtist(ModelMap map, @PathVariable Long id) {
		Artist artist = artistService.getArtistById(id).get();
		map.put("artist", artist);
		return "test_artist";
	}
	
	@GetMapping("/genre/{id}")
	public String getGenre(ModelMap map, @PathVariable Long id) {
		Genre genre = genreService.getGenreById(id).get();
		map.put("genre", genre);
		return "test_genre";
	}
	
	@PostMapping("/search")
	public String searchAll(@RequestParam(name="generalSearch") String search,
			@RequestParam(name="minPrice") String min,
			@RequestParam(name="maxPrice") String max,
			@RequestParam(name="criteria") String criteria,
			ModelMap map) {
			logger.info("======================>>> controller: "+criteria);
			map.put("albums", albumService.search(search, criteria));
			map.put("songs", songService.search(search, criteria));
			map.put("artists", artistService.search(search, criteria));
			map.put("genres", genreService.search(search, criteria));

		return "test_home";
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

		Iterable<Genre> genres = genreService.getAllGenre();
		Iterable<Artist> artists = artistService.getAllArtist();
		model.put("genres", genres);
		model.put("artists", artists);
		
		return "admin-create-album";
	}
	
	@PostMapping("/admin/album/create")
	public RedirectView createAlbumProduct(ModelMap model, Album album, @RequestParam Long artist_id) {
		
		album.setArtist(artistService.getArtistById(artist_id).get());

		logger.info(album.toString());

		albumService.createAlbum(album);
		return new RedirectView("/admin/");

	}
	
	@GetMapping("/admin/album/{id}")
	public String getAlbumProduct(ModelMap model, @PathVariable Long id) {
		
		Album album = albumService.getAlbumById(id).get();
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
		if (albumService.updateAlbum(id, album)) {
			return new ModelAndView("redirect:/admin/");
		}
		model.put("error", "There was an error updating the album");
		return new ModelAndView("redirect:/admin/album/" + id, model);
	}
	
	@GetMapping("/admin/album/delete/{id}")
	public RedirectView deleteAlbumProduct(@PathVariable Long id) {
		logger.info("inside delete function");
		
		// need to add model for delete success and failure
		
		if (albumService.deleteAlbum(id)) {
			return new RedirectView("/admin/");
		}
		return new RedirectView("/admin/");
	}

}

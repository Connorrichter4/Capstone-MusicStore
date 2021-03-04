package com.hcl.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class SongController {
	
	private Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService songService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	ArtistService artistService;
	
	
	@RequestMapping(value="/testSongController", method=RequestMethod.GET)
	public String showSongs(ModelMap model) {
		Iterable<Song> listOfSongs = songService.getAllSong();
		listOfSongs.forEach(song -> logger.info(song.toString()));
		model.put("allSongs", songService.getAllSong());
		return "testSongController";
	}
	
	@RequestMapping(value="/searchById", method=RequestMethod.POST)
	public String SearchSongById(@RequestParam Long id, ModelMap model) {
		Optional<Song> song = songService.getSongById(id);
		if(!song.isPresent()) {
			model.addAttribute("songIdNotFound", "The Song does not exist.");
		}else {
			model.addAttribute("songFoundById", song.get());
			logger.info(song.toString());
		}
		return "testSongController";
	}
	
	@RequestMapping(value="/searchByName", method=RequestMethod.POST)
	public String SearchSongByName(@RequestParam String name, ModelMap model) {
		List<Song> songs = songService.getSongByName(name);
		if(songs.isEmpty()) {
			model.addAttribute("songNameNotFound", "The Song does not exist.");
		}else {
			model.addAttribute("songFoundByName", songs);
			logger.info(songs.toString());
		}
		return "testSongController";
	}
	
	@RequestMapping(value="/searchByPriceRange", method=RequestMethod.POST)
	public String SearchSongByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice, ModelMap model) {
		List<Song> songs = songService.getSongByPriceRange(minPrice, maxPrice);
		if(songs.isEmpty()) {
			model.addAttribute("songPriceNotFound", "No Song in this Range exists.");
		}else {
			model.addAttribute("songFoundByPrice", songs);
			logger.info(songs.toString());
		}
		return "testSongController";
	}
	
	@RequestMapping(value="/searchByAlbumName", method=RequestMethod.POST)
	public String SearchSongByAlbumName(@RequestParam String albumName, ModelMap model) {
		List<Song> songs = songService.getSongByAlbumName(albumName);
		if(songs.isEmpty()) {
			model.addAttribute("songAlbumNotFound", "The Song does not exist.");
		}else {
			model.addAttribute("songFoundByAlbumName", songs);
			logger.info(songs.toString());
		}
		return "testSongController";
	}
	
	@RequestMapping(value="/searchByArtistName", method=RequestMethod.POST)
	public String SearchSongByArtistName(@RequestParam String artistName, ModelMap model) {
		List<Song> songs = songService.getSongByArtistName(artistName);
		if(songs.isEmpty()) {
			model.addAttribute("songArtistNotFound", "The Song does not exist.");
		}else {
			model.addAttribute("songFoundByArtistName", songs);
			logger.info(songs.toString());
		}
		return "testSongController";
	}
	
	/*
	 * @RequestMapping(value="/addSong", method=RequestMethod.POST) String
	 * addSongs(@RequestParam String name, @RequestParam Double price,
	 * 
	 * @RequestParam Long inventory, Artist artist, Album album) {
	 * songService.createSong(name, price, inventory, artist, album); return
	 * "testSongController"; }
	 */
	

	@GetMapping("admin/song/create")
	public String createSongForm(ModelMap model) {

		Iterable<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		model.put("albums", albums);
		model.put("artists", artists);
		
		return "admin-create-song";
	}

	@PostMapping("admin/song/create")
	public RedirectView createSongProduct(ModelMap model, Song song, @RequestParam Long artist_id,
			@RequestParam Long album_id) {
		
		song.setAlbum(albumService.findAlbum(album_id));
		song.setArtist(artistService.getArtistById(artist_id).get());


		songService.createSong(song);
		return new RedirectView("/admin/");

	}
	
	@GetMapping("/admin/song/{id}")
	public String getSongProduct(ModelMap model, @PathVariable Long id) {
		Song song = songService.getSongById(id).get();
		logger.info(song.toString());
		Iterable<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		model.put("albums", albums);
		model.put("artists", artists);
		model.put("song", song);
		return "admin-edit-song";
	}

	@PostMapping("/admin/song/{id}")
	public ModelAndView updateSongProduct(ModelMap model, @PathVariable Long id, Song song,
			@RequestParam Long artist_id, @RequestParam Long album_id) {
		song.setAlbum(albumService.findAlbum(album_id));
		song.setArtist(artistService.getArtistById(artist_id).get());

		logger.info(song.toString());
		if (songService.updateSong(id, song)) {
			return new ModelAndView("redirect:/admin/");
		}
		model.put("error", "There was an error updating the song");
		return new ModelAndView("redirect:/admin/song/" + id, model);
	}
	
	@GetMapping("/admin/song/delete/{id}")
	public RedirectView deleteSongProduct(@PathVariable Long id) {
		logger.info("inside delete function");
		
		// need to add model for delete success and failure
		
		if (songService.deleteSong(id)) {
			return new RedirectView("/admin/");
		}
		return new RedirectView("/admin/");
	}

}

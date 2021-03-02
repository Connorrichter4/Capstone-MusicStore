package com.hcl.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.services.SongService;

@Controller
public class SongController {
	
	private Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService songService;
	
	
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
		if(song.isEmpty()) {
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
	
	

}
